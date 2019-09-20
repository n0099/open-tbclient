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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {
    private final String bBu = TbConfig.getTempDirName();
    private a bBv;
    private c bBw;
    private final Context mContext;

    /* renamed from: com.baidu.tbadk.album.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0246b {
        void Q(List<ImageFileInfo> list);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public boolean a(com.baidu.tbadk.album.c cVar) {
        if (cVar == null) {
            return false;
        }
        aau();
        this.bBv = new a(cVar);
        this.bBv.setPriority(3);
        this.bBv.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, d dVar) {
        if (dVar == null) {
            return false;
        }
        aav();
        this.bBw = new c(str, dVar);
        this.bBw.setPriority(3);
        this.bBw.execute(new Void[0]);
        return true;
    }

    public void aau() {
        if (this.bBv != null) {
            this.bBv.cancel();
            this.bBv = null;
        }
    }

    public void aav() {
        if (this.bBw != null) {
            this.bBw.cancel();
            this.bBw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, List<com.baidu.tbadk.album.a>> {
        private final com.baidu.tbadk.album.c bBx;

        public a(com.baidu.tbadk.album.c cVar) {
            this.bBx = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public List<com.baidu.tbadk.album.a> doInBackground(Object... objArr) {
            return b.this.aaw();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.bBx != null) {
                this.bBx.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public void onPostExecute(List<com.baidu.tbadk.album.a> list) {
            super.onPostExecute(list);
            if (this.bBx != null) {
                this.bBx.R(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tbadk.album.a> aaw() {
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
                                    String lB = lB(file2.getAbsolutePath());
                                    if (lB != null && (matcher = compile.matcher(lB)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
                                aVar.lz(string);
                                aVar.lA(i + "");
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(aq.aX(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                aVar.a(imageFileInfo);
                                aVar.setName(string2);
                                if (string2 != null && string2.equals(this.bBu)) {
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

    public String lB(String str) {
        String lC = lC(str);
        if (lC == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(lC.toLowerCase(Locale.getDefault()));
    }

    private String lC(String str) {
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
    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
        private final String bBA;
        private String bBB;
        private List<com.baidu.tbadk.album.a> bBC;
        private int bBD = 1;
        private InterfaceC0246b bBE = new InterfaceC0246b() { // from class: com.baidu.tbadk.album.b.c.1
            @Override // com.baidu.tbadk.album.b.InterfaceC0246b
            public void Q(List<ImageFileInfo> list) {
                c.this.publishProgress(list);
            }
        };
        private final d bBz;

        public c(String str, d dVar) {
            this.bBz = dVar;
            this.bBA = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.bBA)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.bBA.equals(com.baidu.tbadk.album.a.bBq)) {
                this.bBC = b.this.aaw();
                if (this.bBC != null) {
                    for (com.baidu.tbadk.album.a aVar : this.bBC) {
                        String albumId = aVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.bBE, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.bBE, this.bBA);
            return arrayList;
        }

        private void a(List<ImageFileInfo> list, InterfaceC0246b interfaceC0246b, String str) {
            if (list != null) {
                a(list, interfaceC0246b, str, b.this.mContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (list == null || list.size() <= 0) {
                    a(list, interfaceC0246b, str, b.this.mContext, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (this.bBz != null) {
                this.bBz.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.bBz != null) {
                this.bBz.a(this.bBC, listArr[0], this.bBB);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute(list);
            if (this.bBz != null) {
                this.bBz.a(this.bBC, list, this.bBB);
            }
        }

        private void a(List<ImageFileInfo> list, InterfaceC0246b interfaceC0246b) {
            if (list != null && interfaceC0246b != null) {
                if (this.bBD == 1 || this.bBD == 2) {
                    if (list.size() / this.bBD > 50) {
                        if (interfaceC0246b != null) {
                            interfaceC0246b.Q(list);
                        }
                        this.bBD++;
                    }
                } else if (list.size() / this.bBD > 500) {
                    if (interfaceC0246b != null) {
                        interfaceC0246b.Q(list);
                    }
                    this.bBD++;
                }
            }
        }

        private void a(List<ImageFileInfo> list, InterfaceC0246b interfaceC0246b, String str, Context context, Uri uri) {
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
                                    this.bBB = cursor.getString(columnIndex2);
                                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                                    imageFileInfo.setAlbumnId(str);
                                    imageFileInfo.setFilePath(string);
                                    File file = new File(string);
                                    if (file.exists() && file.isFile() && file.length() > 0) {
                                        boolean z = false;
                                        boolean z2 = false;
                                        if (string.toLowerCase().endsWith(".gif") && m.nw(string)) {
                                            if (com.baidu.adp.lib.util.f.i(file) <= 3145728) {
                                                z = true;
                                            }
                                        } else if (m.nx(string)) {
                                            z2 = true;
                                        }
                                        imageFileInfo.setIsGif(z);
                                        imageFileInfo.setIsLong(z2);
                                        imageFileInfo.setModifyTime(aq.aX(file.lastModified()));
                                        list.add(imageFileInfo);
                                        a(list, interfaceC0246b);
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
