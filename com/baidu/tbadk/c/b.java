package com.baidu.tbadk.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.img.ImageFileInfo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class b {
    private final String QC = TbConfig.getTempDirName();
    private a QD;
    private c QE;
    private final Context mContext;

    /* renamed from: com.baidu.tbadk.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0043b {
        void l(List<ImageFileInfo> list);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public boolean a(com.baidu.tbadk.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        nC();
        this.QD = new a(cVar);
        this.QD.setPriority(3);
        this.QD.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, d dVar) {
        if (dVar == null) {
            return false;
        }
        nD();
        this.QE = new c(str, dVar);
        this.QE.setPriority(3);
        this.QE.execute(new Void[0]);
        return true;
    }

    public void nC() {
        if (this.QD != null) {
            this.QD.cancel();
            this.QD = null;
        }
    }

    public void nD() {
        if (this.QE != null) {
            this.QE.cancel();
            this.QE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, List<com.baidu.tbadk.c.a>> {
        private final com.baidu.tbadk.c.c QF;

        public a(com.baidu.tbadk.c.c cVar) {
            this.QF = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public List<com.baidu.tbadk.c.a> doInBackground(Object... objArr) {
            return b.this.nE();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            if (this.QF != null) {
                this.QF.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(List<com.baidu.tbadk.c.a> list) {
            super.onPostExecute((a) list);
            if (this.QF != null) {
                this.QF.m(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tbadk.c.a> nE() {
        HashSet<String> hashSet = new HashSet<>();
        return a(this.mContext, a(this.mContext, null, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, hashSet), MediaStore.Images.Media.INTERNAL_CONTENT_URI, hashSet);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0142 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    private List<com.baidu.tbadk.c.a> a(Context context, List<com.baidu.tbadk.c.a> list, Uri uri, HashSet<String> hashSet) {
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
                                    String bY = bY(file2.getAbsolutePath());
                                    if (bY != null && (matcher = compile.matcher(bY)) != null && matcher.matches()) {
                                        i++;
                                    }
                                }
                            }
                            if (i != 0) {
                                com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a();
                                aVar.bW(string);
                                aVar.bX(i + "");
                                ImageFileInfo imageFileInfo = new ImageFileInfo();
                                File file3 = new File(string3);
                                if (file3.exists() && file3.isFile()) {
                                    imageFileInfo.setModifyTime(am.J(file3.lastModified()));
                                }
                                imageFileInfo.setFilePath(string3);
                                aVar.a(imageFileInfo);
                                aVar.setName(string2);
                                if (string2 != null && string2.equals(this.QC)) {
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

    public String bY(String str) {
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
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, List<ImageFileInfo>, List<ImageFileInfo>> {
        private final d QH;
        private final String QI;
        private String QJ;
        private List<com.baidu.tbadk.c.a> QK;
        private int QL = 1;
        private InterfaceC0043b QM = new InterfaceC0043b() { // from class: com.baidu.tbadk.c.b.c.1
            @Override // com.baidu.tbadk.c.b.InterfaceC0043b
            public void l(List<ImageFileInfo> list) {
                c.this.publishProgress(list);
            }
        };

        public c(String str, d dVar) {
            this.QH = dVar;
            this.QI = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<ImageFileInfo> doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.QI)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (this.QI.equals("-1")) {
                this.QK = b.this.nE();
                if (this.QK != null) {
                    for (com.baidu.tbadk.c.a aVar : this.QK) {
                        String albumId = aVar.getAlbumId();
                        if (!TextUtils.isEmpty(albumId)) {
                            a(arrayList, this.QM, albumId);
                        }
                    }
                }
                return arrayList;
            }
            a(arrayList, this.QM, this.QI);
            return arrayList;
        }

        private void a(List<ImageFileInfo> list, InterfaceC0043b interfaceC0043b, String str) {
            if (list != null) {
                a(list, interfaceC0043b, str, b.this.mContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (list == null || list.size() <= 0) {
                    a(list, interfaceC0043b, str, b.this.mContext, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (this.QH != null) {
                this.QH.onPreLoad();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(List<ImageFileInfo>... listArr) {
            super.onProgressUpdate(listArr);
            if (listArr.length > 0 && this.QH != null) {
                this.QH.a(this.QK, listArr[0], this.QJ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(List<ImageFileInfo> list) {
            super.onPostExecute((c) list);
            if (this.QH != null) {
                this.QH.a(this.QK, list, this.QJ);
            }
        }

        private void a(List<ImageFileInfo> list, InterfaceC0043b interfaceC0043b) {
            if (list != null && interfaceC0043b != null) {
                if (this.QL == 1 || this.QL == 2) {
                    if (list.size() / this.QL > 50) {
                        if (interfaceC0043b != null) {
                            interfaceC0043b.l(list);
                        }
                        this.QL++;
                    }
                } else if (list.size() / this.QL > 500) {
                    if (interfaceC0043b != null) {
                        interfaceC0043b.l(list);
                    }
                    this.QL++;
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [490=4, 506=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00d2 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
        private void a(List<ImageFileInfo> list, InterfaceC0043b interfaceC0043b, String str, Context context, Uri uri) {
            Cursor cursor;
            InputStream f;
            if (list == null) {
                return;
            }
            ?? r1 = "bucket_display_name";
            try {
                try {
                    cursor = context.getContentResolver().query(uri, new String[]{"bucket_id", "_data", "bucket_display_name"}, "bucket_id=?", new String[]{str}, "datetaken DESC");
                    try {
                        if (!cursor.moveToFirst()) {
                            com.baidu.adp.lib.g.a.e(cursor);
                        }
                        int columnIndex = cursor.getColumnIndex("_data");
                        int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                        do {
                            String string = cursor.getString(columnIndex);
                            this.QJ = cursor.getString(columnIndex2);
                            ImageFileInfo imageFileInfo = new ImageFileInfo();
                            imageFileInfo.setAlbumnId(str);
                            imageFileInfo.setFilePath(string);
                            File file = new File(string);
                            if (file.exists() && file.length() > 0) {
                                if (string.toLowerCase().endsWith(".gif") && (f = e.f(file)) != null) {
                                    try {
                                        byte[] bArr = new byte[7];
                                        r0 = f.read(bArr, 0, 6) == 6 ? k.j(bArr) : false;
                                        if (!r0 || e.g(file) <= 3145728) {
                                            com.baidu.adp.lib.g.a.d(f);
                                        } else {
                                            com.baidu.adp.lib.g.a.d(f);
                                        }
                                    } catch (IOException e) {
                                        com.baidu.adp.lib.g.a.d(f);
                                    } catch (Throwable th) {
                                        com.baidu.adp.lib.g.a.d(f);
                                        throw th;
                                    }
                                }
                                imageFileInfo.setIsGif(r0);
                                imageFileInfo.setModifyTime(am.J(file.lastModified()));
                                list.add(imageFileInfo);
                                a(list, interfaceC0043b);
                            }
                        } while (cursor.moveToNext());
                        com.baidu.adp.lib.g.a.e(cursor);
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.detailException(e);
                        com.baidu.adp.lib.g.a.e(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.e(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                r1 = 0;
                com.baidu.adp.lib.g.a.e(r1);
                throw th;
            }
        }
    }
}
