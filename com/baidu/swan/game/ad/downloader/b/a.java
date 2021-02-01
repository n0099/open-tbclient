package com.baidu.swan.game.ad.downloader.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes5.dex */
public final class a implements com.baidu.swan.game.ad.downloader.c.a {
    private final b dYn;
    private final SQLiteDatabase dYo;
    private final SQLiteDatabase dYp;
    private final Context mContext;
    public static final String[] dYm = {IMConstants.MSG_ROW_ID, "createAt", DownloadDataConstants.Columns.COLUMN_URI, "packagename", "path", TiebaInitialize.LogFields.SIZE, "progress", "status"};
    public static final int STATUS_COMPLETED = SwanAdDownloadState.DOWNLOADED.value();
    public static final int STATUS_PAUSED = SwanAdDownloadState.DOWNLOAD_PAUSED.value();

    public a(Context context, com.baidu.swan.game.ad.downloader.a.a aVar) {
        this.mContext = context;
        this.dYn = new b(context, aVar);
        this.dYo = this.dYn.getWritableDatabase();
        this.dYp = this.dYn.getReadableDatabase();
    }

    private void a(Cursor cursor, DownloadInfo downloadInfo) {
        int columnIndex = cursor.getColumnIndex(IMConstants.MSG_ROW_ID);
        int columnIndex2 = cursor.getColumnIndex("createAt");
        int columnIndex3 = cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_URI);
        int columnIndex4 = cursor.getColumnIndex("packagename");
        int columnIndex5 = cursor.getColumnIndex("path");
        int columnIndex6 = cursor.getColumnIndex(TiebaInitialize.LogFields.SIZE);
        int columnIndex7 = cursor.getColumnIndex("progress");
        int columnIndex8 = cursor.getColumnIndex("status");
        downloadInfo.setId(cursor.getString(columnIndex));
        downloadInfo.setCreateAt(cursor.getLong(columnIndex2));
        downloadInfo.setUri(cursor.getString(columnIndex3));
        downloadInfo.setPackageName(cursor.getString(columnIndex4));
        downloadInfo.setPath(cursor.getString(columnIndex5));
        downloadInfo.setSize(cursor.getLong(columnIndex6));
        downloadInfo.setProgress(cursor.getLong(columnIndex7));
        downloadInfo.setStatus(cursor.getInt(columnIndex8));
    }

    @Override // com.baidu.swan.game.ad.downloader.c.a
    public DownloadInfo vc(String str) {
        Cursor query = this.dYp.query("ad_download", dYm, "_id=?", new String[]{str}, null, null, "createAt desc");
        if (query.moveToNext()) {
            DownloadInfo downloadInfo = new DownloadInfo();
            a(query, downloadInfo);
            query.close();
            return downloadInfo;
        }
        query.close();
        return null;
    }

    @Override // com.baidu.swan.game.ad.downloader.c.a
    public void aRH() {
        this.dYo.execSQL("UPDATE ad_download SET status=? WHERE status!=?;", new Object[]{Integer.valueOf(STATUS_PAUSED), Integer.valueOf(STATUS_COMPLETED)});
    }

    @Override // com.baidu.swan.game.ad.downloader.c.a
    public void m(DownloadInfo downloadInfo) {
        this.dYo.execSQL("REPLACE INTO ad_download(_id,createAt,uri,packagename,path,size,progress,status)VALUES(?,?,?,?,?,?,?,?);", new Object[]{downloadInfo.getId(), Long.valueOf(downloadInfo.getCreateAt()), downloadInfo.getUri(), downloadInfo.getPackageName(), downloadInfo.getPath(), Long.valueOf(downloadInfo.getSize()), Long.valueOf(downloadInfo.getProgress()), Integer.valueOf(downloadInfo.getStatus())});
    }

    @Override // com.baidu.swan.game.ad.downloader.c.a
    public void n(DownloadInfo downloadInfo) {
        this.dYo.delete("ad_download", "_id=?", new String[]{String.valueOf(downloadInfo.getId())});
    }
}
