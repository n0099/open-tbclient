package com.baidu.android.imsdk.pubaccount.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.db.CursorParse;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PaInfoDBManager extends DBBase {
    private static final String TAG = PaInfoDBManager.class.getSimpleName();
    private static PaInfoDBManager mInstance = null;

    private PaInfoDBManager(Context context) {
        setContext(context);
    }

    public static PaInfoDBManager getInstance(Context context) {
        synchronized (mSyncLock) {
            if (mInstance == null) {
                mInstance = new PaInfoDBManager(context);
            }
        }
        return mInstance;
    }

    public long subscribePa(PaInfo paInfo) {
        long add;
        ContentValues contentValues = new ContentValues();
        contentValues.put("paid", Long.valueOf(paInfo.getPaId()));
        contentValues.put("nickname", paInfo.getNickName());
        contentValues.put("url", paInfo.getUrl());
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, paInfo.getAvatar());
        contentValues.put("description", paInfo.getDescription());
        contentValues.put("acceptpush", Integer.valueOf(paInfo.isAcceptPush() ? 1 : 0));
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("detail", paInfo.getDetail());
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_TPL, Long.valueOf(paInfo.getTPL()));
        contentValues.put("disturb", Integer.valueOf(paInfo.getDisturb()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE, Integer.valueOf(paInfo.getSubtype()));
        contentValues.put("classtype", Integer.valueOf(paInfo.getClassType()));
        contentValues.put("classtitle", paInfo.getClassTitle());
        contentValues.put("classavatar", paInfo.getClassavatar());
        contentValues.put("classshow", Integer.valueOf(paInfo.getClassshow()));
        contentValues.put("status", Integer.valueOf(paInfo.getStatus()));
        contentValues.put("marktop", Integer.valueOf(paInfo.getMarkTop()));
        contentValues.put("marktoptime", Long.valueOf(paInfo.getMarkTopTime()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE, Integer.valueOf(paInfo.getSubsetType()));
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT, paInfo.getPaExt());
        synchronized (mSyncLock) {
            add = add(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(paInfo.getPaId())}, contentValues);
        }
        return add;
    }

    public int setPaQuickRelies(long j, String str, long j2) {
        int update;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REPLIES, str);
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME, Long.valueOf(j2));
        synchronized (mSyncLock) {
            update = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues);
        }
        return update;
    }

    public int deleteAllSubscribedPa() {
        int delete;
        synchronized (mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null);
        }
        return delete;
    }

    public int unSubscribePa(long j) {
        int delete;
        if (j < 0) {
            return -1;
        }
        synchronized (mSyncLock) {
            delete = delete(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)});
        }
        return delete;
    }

    public PaInfo queryPaInfo(long j) {
        PaInfo result;
        PaInfoParse paInfoParse = new PaInfoParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "paid = ?", new String[]{Long.toString(j)}, null, null, null, paInfoParse);
            result = paInfoParse.getResult();
        }
        return result;
    }

    public List<PaInfo> querySubscribedPaList() {
        List<PaInfo> result;
        PaInfoListParse paInfoListParse = new PaInfoListParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, null, null, null, null, null, paInfoListParse);
            result = paInfoListParse.getResult();
        }
        return result;
    }

    public List<PaInfo> queryPaInfoByChatType(int i) {
        List<PaInfo> result;
        PaInfoListParse paInfoListParse = new PaInfoListParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, null, "pasubtype=?", new String[]{Integer.toString(i)}, null, null, null, paInfoListParse);
            result = paInfoListParse.getResult();
        }
        return result;
    }

    public ArrayList<Long> queryPaidList() {
        ArrayList<Long> result;
        PaidParse paidParse = new PaidParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, null, null, null, null, null, paidParse);
            result = paidParse.getResult();
        }
        return result;
    }

    /* loaded from: classes6.dex */
    class PaInfoParse implements CursorParse {
        PaInfo info = null;

        PaInfoParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    this.info = PaInfoDBManager.this.constructPaInfo(cursor);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public PaInfo getResult() {
            return this.info;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PaInfoListParse implements CursorParse {
        List<PaInfo> paList = null;

        PaInfoListParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                this.paList = new ArrayList();
                while (cursor.moveToNext()) {
                    this.paList.add(PaInfoDBManager.this.constructPaInfo(cursor));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public List<PaInfo> getResult() {
            return this.paList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PaidParse implements CursorParse {
        ArrayList<Long> paList = null;

        PaidParse() {
        }

        @Override // com.baidu.android.imsdk.db.CursorParse
        public void parseCursor(Cursor cursor) {
            if (cursor != null) {
                this.paList = new ArrayList<>();
                while (cursor.moveToNext()) {
                    this.paList.add(Long.valueOf(cursor.getLong(0)));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.android.imsdk.db.CursorParse
        public ArrayList<Long> getResult() {
            return this.paList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PaInfo constructPaInfo(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("paid"));
        String string = cursor.getString(cursor.getColumnIndex("nickname"));
        String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_AVATAR));
        String string3 = cursor.getString(cursor.getColumnIndex("description"));
        int i = cursor.getInt(cursor.getColumnIndex("acceptpush"));
        String string4 = cursor.getString(cursor.getColumnIndex("url"));
        long j2 = cursor.getLong(cursor.getColumnIndex("timestamp"));
        String string5 = cursor.getString(cursor.getColumnIndex("detail"));
        long j3 = cursor.getLong(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_TPL));
        int i2 = cursor.getInt(cursor.getColumnIndex("disturb"));
        int i3 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE));
        int i4 = cursor.getInt(cursor.getColumnIndex("classtype"));
        int i5 = cursor.getInt(cursor.getColumnIndex("classshow"));
        String string6 = cursor.getString(cursor.getColumnIndex("classtitle"));
        String string7 = cursor.getString(cursor.getColumnIndex("classavatar"));
        int i6 = cursor.getInt(cursor.getColumnIndex("marktop"));
        long j4 = cursor.getLong(cursor.getColumnIndex("marktoptime"));
        int i7 = cursor.getInt(cursor.getColumnIndex("status"));
        String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REPLIES));
        long j5 = cursor.getLong(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME));
        int i8 = cursor.getInt(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE));
        String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.PaSubscribeColumns.COLUMN_PA_EXT));
        PaInfo paInfo = new PaInfo();
        paInfo.setPaId(j);
        paInfo.setNickName(string);
        paInfo.setAvatar(string2);
        paInfo.setDescription(string3);
        paInfo.setUrl(string4);
        paInfo.setAcceptPush(i == 1);
        paInfo.setSubcribeTime(j2);
        paInfo.setDetail(string5);
        paInfo.setTPL(j3);
        paInfo.setDisturb(i2);
        paInfo.setSubtype(i3);
        paInfo.setClassType(i4);
        paInfo.setClasstitle(string6);
        paInfo.setClassAvatar(string7);
        paInfo.setClassshow(i5);
        paInfo.setStatus(i7);
        paInfo.setMarkTop(i6);
        paInfo.setMarkTopTime(j4);
        paInfo.setRepliesStr(string8);
        paInfo.setLastRefreshTime(j5);
        paInfo.setSubsetType(i8);
        paInfo.setPaExt(string9);
        return paInfo;
    }

    public boolean acceptPaPush(long j, boolean z) {
        boolean z2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("acceptpush", Integer.valueOf(z ? 1 : 0));
        synchronized (mSyncLock) {
            z2 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z2;
    }

    public boolean updateDisturb(long j, int i) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("disturb", Integer.valueOf(i));
        synchronized (mSyncLock) {
            z = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z;
    }

    public boolean updateSubsetType(long j, int i) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE, Integer.valueOf(i));
        synchronized (mSyncLock) {
            z = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid=?", new String[]{String.valueOf(j)}, contentValues) > 0;
        }
        return z;
    }

    public boolean updateMarkTop(long j, int i, long j2) {
        boolean z;
        LogUtils.d(TAG, "updateMarkTop, paid=" + j + ", markToped=" + i + ", updateTime=" + j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("marktop", Integer.valueOf(i));
        contentValues.put("marktoptime", Long.valueOf(j2));
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("marktop", Integer.valueOf(i));
        contentValues2.put("marktoptime", Long.valueOf(j2));
        synchronized (mSyncLock) {
            boolean z2 = update(TableDefine.DB_TABLE_PA_SUBSCRIBE, "paid =? ", new String[]{String.valueOf(j)}, contentValues) > 0;
            boolean z3 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(j)}, contentValues2) > 0;
            if (z3) {
                ChatSessionManagerImpl.getInstance(this.mContext).triggerChatSessionChangerCallBack(1, ChatMsgManager.getChatSession(this.mContext, 0, j, j));
            }
            z = z2 || z3;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [328=4] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[Catch: all -> 0x006a, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0006, B:6:0x000c, B:14:0x0039, B:15:0x003c, B:16:0x003f, B:33:0x0071, B:34:0x0074, B:35:0x0077, B:23:0x0062, B:24:0x0065, B:25:0x0068), top: B:43:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071 A[Catch: all -> 0x006a, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0006, B:6:0x000c, B:14:0x0039, B:15:0x003c, B:16:0x003f, B:33:0x0071, B:34:0x0074, B:35:0x0077, B:23:0x0062, B:24:0x0065, B:25:0x0068), top: B:43:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isSubscribed(long j) {
        Cursor cursor;
        boolean z;
        synchronized (mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return false;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "paid=?", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                z = true;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                closeDatabase();
                                return z;
                            }
                        } catch (Exception e) {
                            e = e;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(LogUtils.TAG, "isSubscribed:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            closeDatabase();
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        closeDatabase();
                        throw th;
                    }
                }
                z = false;
                if (cursor != null) {
                }
                closeDatabase();
                return z;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                closeDatabase();
                throw th;
            }
        }
    }

    public ArrayList<Long> queryPaIdByPaType(int i) {
        ArrayList<Long> result;
        PaidParse paidParse = new PaidParse();
        synchronized (mSyncLock) {
            query(TableDefine.DB_TABLE_PA_SUBSCRIBE, new String[]{"paid"}, "pasubtype = ?", new String[]{Integer.toString(i)}, null, null, null, paidParse);
            result = paidParse.getResult();
        }
        return result;
    }
}
