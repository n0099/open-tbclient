package com.baidu.tbadk.album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class f {
    private a Rz;
    private final Context mContext;
    private final String Rn = TbConfig.getTempDirName();
    private int RA = 0;
    private String[] RB = {"bucket_id", "bucket_display_name", "_data"};
    private String[] RC = {"bucket_id", "_data", "bucket_display_name", "datetaken", "date_modified", "date_added"};
    private String[] RD = {"_id", "_data", VrPlayerActivityConfig.TITLE, "mime_type", "_display_name", "duration", "datetaken", "date_modified", "date_added"};
    private String[] RE = {"video_id", "_data", "width", "height"};

    public f(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g nG() {
        List<ImageFileInfo> O;
        g gVar = new g();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        List<com.baidu.tbadk.album.a> ax = ax(this.mContext);
        if (!v.w(ax)) {
            for (com.baidu.tbadk.album.a aVar : ax) {
                String albumId = aVar.getAlbumId();
                if (!TextUtils.isEmpty(albumId) && (O = O(this.mContext, albumId)) != null) {
                    arrayList2.addAll(O);
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.addAll(O);
                    aVar.l(arrayList4);
                }
            }
        }
        arrayList.addAll(ax);
        List<VideoFileInfo> ay = ay(this.mContext);
        if (!v.w(ay) && this.RA != 2) {
            arrayList3.addAll(ay);
        }
        ArrayList arrayList5 = new ArrayList();
        arrayList5.addAll(arrayList2);
        arrayList5.addAll(arrayList3);
        Collections.sort(arrayList5, new Comparator<MediaFileInfo>() { // from class: com.baidu.tbadk.album.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
                return mediaFileInfo2.getSortTime() - mediaFileInfo.getSortTime();
            }
        });
        gVar.RH = arrayList;
        gVar.RK = arrayList2;
        gVar.RJ = arrayList3;
        gVar.RI = arrayList5;
        return gVar;
    }

    public String cc(String str) {
        String fileExtensionFromUrl = getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase(Locale.getDefault()));
    }

    private String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }

    private List<com.baidu.tbadk.album.a> ax(Context context) {
        int i;
        File[] listFiles;
        Matcher matcher;
        Cursor cursor = null;
        if (context == null) {
            return null;
        }
        Pattern compile = Pattern.compile("image\\/\\w+", 2);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        try {
            cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.RB, "mime_type like 'image/%') GROUP BY 1,(2", null, "date_added DESC");
        } catch (Exception e) {
            BdLog.detailException(e);
        } finally {
            com.baidu.adp.lib.g.a.e(cursor);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            String string = cursor.getString(cursor.getColumnIndex("bucket_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("bucket_display_name"));
            String string3 = cursor.getString(cursor.getColumnIndex("_data"));
            String lowerCase = string3.substring(0, string3.lastIndexOf("/")).toLowerCase();
            if (!hashSet.contains(lowerCase)) {
                hashSet.add(lowerCase);
                File file = new File(lowerCase);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    i = 0;
                    for (File file2 : listFiles) {
                        String cc = cc(file2.getAbsolutePath());
                        if (cc != null && (matcher = compile.matcher(cc)) != null && matcher.matches()) {
                            i++;
                        }
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
                    aVar.ca(string);
                    aVar.setName(string2);
                    aVar.cb(String.valueOf(i));
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(string3);
                    File file3 = new File(string3);
                    if (file3.exists() && file3.isFile()) {
                        imageFileInfo.setModifyTime(am.J(file3.lastModified()));
                    }
                    aVar.a(imageFileInfo);
                    if (string2 != null && string2.equals(this.Rn)) {
                        arrayList.add(0, aVar);
                    } else {
                        arrayList.add(aVar);
                    }
                }
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    private List<ImageFileInfo> O(Context context, String str) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        HashSet hashSet = new HashSet();
        try {
            try {
                cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.RC, "bucket_id=?", new String[]{str}, "date_added DESC");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                cursor.getString(cursor.getColumnIndex("bucket_display_name"));
                                cursor.getInt(cursor.getColumnIndex("datetaken"));
                                int i = cursor.getInt(cursor.getColumnIndex("date_added"));
                                cursor.getInt(cursor.getColumnIndex("date_modified"));
                                if (!hashSet.contains(string)) {
                                    hashSet.add(string);
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(str);
                                    imageFileInfo.setFilePath(string);
                                    File file = new File(string);
                                    if (file.exists() && file.isFile() && file.length() > 0) {
                                        boolean z = false;
                                        boolean z2 = false;
                                        if (string.toLowerCase().endsWith(".gif") && k.dq(string)) {
                                            if (com.baidu.adp.lib.util.f.g(file) <= 3145728) {
                                                z = true;
                                            }
                                        } else if (k.dr(string)) {
                                            z2 = true;
                                        }
                                        imageFileInfo.setIsGif(z);
                                        imageFileInfo.setIsLong(z2);
                                        imageFileInfo.setModifyTime(am.J(file.lastModified()));
                                        imageFileInfo.setSortTime(i);
                                        arrayList.add(imageFileInfo);
                                    }
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (Exception e) {
                        e = e;
                        BdLog.detailException(e);
                        com.baidu.adp.lib.g.a.e(cursor);
                        return arrayList;
                    }
                }
                com.baidu.adp.lib.g.a.e(cursor);
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.e(null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.g.a.e(null);
            throw th;
        }
        return arrayList;
    }

    private List<VideoFileInfo> ay(Context context) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        ContentResolver contentResolver = context.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursor2 = null;
        try {
            cursor = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, this.RD, null, null, "date_added DESC");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            int i = cursor.getInt(cursor.getColumnIndex("_id"));
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                            String string2 = cursor.getString(cursor.getColumnIndexOrThrow(VrPlayerActivityConfig.TITLE));
                            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"));
                            String string4 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                            int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                            cursor.getInt(cursor.getColumnIndex("datetaken"));
                            long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_modified"));
                            int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("date_added"));
                            if (!hashSet.contains(string)) {
                                hashSet.add(string);
                                File file = new File(string);
                                if (file != null && file.exists() && file.isFile() && com.baidu.adp.lib.util.f.g(file) > 0) {
                                    VideoFileInfo videoFileInfo = new VideoFileInfo();
                                    videoFileInfo.videoId = i;
                                    videoFileInfo.videoPath = string;
                                    videoFileInfo.displayName = string3;
                                    videoFileInfo.title = string2;
                                    videoFileInfo.mimeType = string4;
                                    videoFileInfo.videoDuration = i2;
                                    videoFileInfo.lastModified = j;
                                    videoFileInfo.setSortTime(i3);
                                    arrayList.add(videoFileInfo);
                                }
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.g.a.e(cursor);
                    return arrayList;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    com.baidu.adp.lib.g.a.e(cursor2);
                    throw th;
                }
            }
            com.baidu.adp.lib.g.a.e(cursor);
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    public boolean a(int i, e eVar) {
        if (eVar == null) {
            return false;
        }
        nH();
        this.RA = i;
        this.Rz = new a(eVar);
        this.Rz.setPriority(3);
        this.Rz.execute(new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, g> {
        private final e RG;

        public a(e eVar) {
            this.RG = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public g doInBackground(Object... objArr) {
            return f.this.nG();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.RG != null) {
                this.RG.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(g gVar) {
            super.onPostExecute(gVar);
            if (this.RG != null) {
                this.RG.a(gVar);
            }
        }
    }

    public void nH() {
        if (this.Rz != null) {
            this.Rz.cancel();
            this.Rz = null;
        }
    }
}
