package com.baidu.tbadk.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b {
    private final String aab = TbConfig.getTempDirName();
    private a aac;
    private c aad;
    private final Context mContext;

    /* renamed from: com.baidu.tbadk.album.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0096b {
        void q(List<ImageFileInfo> list);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public boolean a(com.baidu.tbadk.album.c cVar) {
        if (cVar == null) {
            return false;
        }
        rA();
        this.aac = new a(cVar);
        this.aac.setPriority(3);
        this.aac.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, d dVar) {
        if (dVar == null) {
            return false;
        }
        rB();
        this.aad = new c(str, dVar);
        this.aad.setPriority(3);
        this.aad.execute(new Void[0]);
        return true;
    }

    public void rA() {
        if (this.aac != null) {
            this.aac.cancel();
            this.aac = null;
        }
    }

    public void rB() {
        if (this.aad != null) {
            this.aad.cancel();
            this.aad = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, Integer, List<com.baidu.tbadk.album.a>> {
        private final com.baidu.tbadk.album.c aae;

        public a(com.baidu.tbadk.album.c cVar) {
            this.aae = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public List<com.baidu.tbadk.album.a> doInBackground(Object... objArr) {
            return b.this.rC();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.aae != null) {
                this.aae.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public void onPostExecute(List<com.baidu.tbadk.album.a> list) {
            super.onPostExecute(list);
            if (this.aae != null) {
                this.aae.r(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tbadk.album.a> rC() {
        HashSet<String> hashSet = new HashSet<>();
        return a(this.mContext, a(this.mContext, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0142 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    private List<com.baidu.tbadk.album.a> a(Context context, List<com.baidu.tbadk.album.a> list, Uri uri, HashSet<String> hashSet) {
        Cursor cursor;
        File[] listFiles;
        Matcher matcher;
        if (context == null) {
            return null;
        }
        Pattern compile = Pattern.compile("image\\/\\w+", 2);
        if (list == null) {
            list = new ArrayList<>();
        }
        ?? r3 = "count(*)";
        try {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "bucket_display_name", "_data", "count(*)"}, "mime_type like 'image/%') GROUP BY 1,(2", null, "date_added DESC");
                try {
                    if (cursor.moveToFirst()) {
                        int columnIndex = cursor.getColumnIndex("bucket_id");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        int columnIndex3 = cursor.getColumnIndex("_data");
                        int columnIndex4 = cursor.getColumnIndex("count(*)");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            String string3 = cursor.getString(columnIndex3);
                            cursor.getString(columnIndex4);
                            int i = 0;
                            String substring = string3.substring(0, string3.lastIndexOf("/"));
                            if (hashSet != null) {
                                if (!hashSet.contains(substring)) {
                                    hashSet.add(substring);
                                }
                            }
                            File file = new File(substring);
                            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                                for (File file2 : listFiles) {
                                    String cH = cH(file2.getAbsolutePath());
                                    if (cH != null && (matcher = compile.matcher(cH)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
                                aVar.cF(string);
                                aVar.cG(i + "");
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(ap.P(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                aVar.a(imageFileInfo);
                                aVar.setName(string2);
                                if (string2 != null && string2.equals(this.aab)) {
                                    list.add(0, aVar);
                                } else {
                                    list.add(aVar);
                                }
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.g.a.e(cursor);
                        return list;
                    }
                    com.baidu.adp.lib.g.a.e(cursor);
                    return list;
                } catch (Exception e) {
                    e = e;
                    BdLog.detailException(e);
                    com.baidu.adp.lib.g.a.e(cursor);
                    return list;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.e(r3);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            r3 = 0;
            com.baidu.adp.lib.g.a.e(r3);
            throw th;
        }
    }

    public String cH(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
        private final d aag;
        private final String aah;
        private String aai;
        private List<com.baidu.tbadk.album.a> aaj;
        private int aak = 1;
        private InterfaceC0096b aal = new InterfaceC0096b() { // from class: com.baidu.tbadk.album.b.c.1
            @Override // com.baidu.tbadk.album.b.InterfaceC0096b
            public void q(List<ImageFileInfo> list) {
                c.this.publishProgress(list);
            }
        };

        public c(String str, d dVar) {
            this.aag = dVar;
            this.aah = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.aah)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.aah.equals(com.baidu.tbadk.album.a.ZX)) {
                this.aaj = b.this.rC();
                if (this.aaj != null) {
                    for (com.baidu.tbadk.album.a aVar : this.aaj) {
                        String albumId = aVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.aal, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.aal, this.aah);
            return arrayList;
        }

        private void a(List<ImageFileInfo> list, InterfaceC0096b interfaceC0096b, String str) {
            if (list != null) {
                a(list, interfaceC0096b, str, b.this.mContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (list == null || list.size() <= 0) {
                    a(list, interfaceC0096b, str, b.this.mContext, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (this.aag != null) {
                this.aag.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.aag != null) {
                this.aag.a(this.aaj, listArr[0], this.aai);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute(list);
            if (this.aag != null) {
                this.aag.a(this.aaj, list, this.aai);
            }
        }

        private void a(List<ImageFileInfo> list, InterfaceC0096b interfaceC0096b) {
            if (list != null && interfaceC0096b != null) {
                if (this.aak == 1 || this.aak == 2) {
                    if (list.size() / this.aak > 50) {
                        if (interfaceC0096b != null) {
                            interfaceC0096b.q(list);
                        }
                        this.aak++;
                    }
                } else if (list.size() / this.aak > 500) {
                    if (interfaceC0096b != null) {
                        interfaceC0096b.q(list);
                    }
                    this.aak++;
                }
            }
        }

        private void a(List<ImageFileInfo> list, InterfaceC0096b interfaceC0096b, String str, Context context, Uri uri) {
            Cursor cursor;
            if (list != null) {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex("_data");
                                int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                                do {
                                    String string = cursor.getString(columnIndex);
                                    this.aai = cursor.getString(columnIndex2);
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(str);
                                    imageFileInfo.setFilePath(string);
                                    File file = new File(string);
                                    if (file.exists() && file.isFile() && file.length() > 0) {
                                        boolean z = false;
                                        boolean z2 = false;
                                        if (string.toLowerCase().endsWith(".gif") && l.ee(string)) {
                                            if (com.baidu.adp.lib.util.f.h(file) <= 3145728) {
                                                z = true;
                                            }
                                        } else if (l.ef(string)) {
                                            z2 = true;
                                        }
                                        imageFileInfo.setIsGif(z);
                                        imageFileInfo.setIsLong(z2);
                                        imageFileInfo.setModifyTime(ap.P(file.lastModified()));
                                        list.add(imageFileInfo);
                                        a(list, interfaceC0096b);
                                    }
                                } while (cursor.moveToNext());
                                com.baidu.adp.lib.g.a.e(cursor);
                            }
                            com.baidu.adp.lib.g.a.e(cursor);
                        } catch (Exception e) {
                            e = e;
                            BdLog.detailException(e);
                            com.baidu.adp.lib.g.a.e(cursor);
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.g.a.e(cursor);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    com.baidu.adp.lib.g.a.e(cursor);
                    throw th;
                }
            }
        }
    }
}
