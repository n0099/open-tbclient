package cn.jiguang.d.h;

import android.content.Context;
import com.google.zxing.common.StringUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class f {
    public static File K(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return new File(filesDir, str);
    }

    public static void a(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
            }
        }
    }

    private static void a(File file, ZipOutputStream zipOutputStream, String str) {
        String str2 = new String((str + (str.trim().length() == 0 ? "" : File.separator) + file.getName()).getBytes("8859_1"), StringUtils.GB2312);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    a(file2, zipOutputStream, str2);
                }
                return;
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    public static void a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            a(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean a(java.io.File r4, java.lang.Object r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L9
            boolean r1 = r4.isDirectory()
            if (r1 == 0) goto La
        L9:
            return r0
        La:
            r2 = 0
            f(r4)     // Catch: java.lang.Throwable -> L20
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L20
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L20
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L20
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L20
            r1.writeObject(r5)     // Catch: java.lang.Throwable -> L2e
            cn.jiguang.g.f.a(r1)
            r0 = 1
            goto L9
        L20:
            r1 = move-exception
            r1 = r2
        L22:
            cn.jiguang.g.f.a(r1)
            goto L9
        L26:
            r0 = move-exception
        L27:
            cn.jiguang.g.f.a(r2)
            throw r0
        L2b:
            r0 = move-exception
            r2 = r1
            goto L27
        L2e:
            r2 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.h.f.a(java.io.File, java.lang.Object):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static boolean a(java.io.File r3, byte[] r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L9
            boolean r1 = r3.isDirectory()
            if (r1 == 0) goto La
        L9:
            return r0
        La:
            r1 = 0
            if (r4 != 0) goto L10
            r2 = 0
            byte[] r4 = new byte[r2]     // Catch: java.lang.Throwable -> L20
        L10:
            f(r3)     // Catch: java.lang.Throwable -> L20
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L20
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L20
            r2.write(r4)     // Catch: java.lang.Throwable -> L2d
            cn.jiguang.g.f.a(r2)
            r0 = 1
            goto L9
        L20:
            r2 = move-exception
        L21:
            cn.jiguang.g.f.a(r1)
            goto L9
        L25:
            r0 = move-exception
        L26:
            cn.jiguang.g.f.a(r1)
            throw r0
        L2a:
            r0 = move-exception
            r1 = r2
            goto L26
        L2d:
            r1 = move-exception
            r1 = r2
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.h.f.a(java.io.File, byte[]):boolean");
    }

    public static File[] a(File file, FileFilter fileFilter) {
        if (file != null && file.exists() && file.isDirectory()) {
            return file.listFiles(fileFilter);
        }
        return null;
    }

    public static boolean b(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = str.getBytes(HTTP.UTF_8);
            } catch (Throwable th) {
                return false;
            }
        } else {
            bytes = null;
        }
        return a(file, bytes);
    }

    public static File[] b(File file, boolean z) {
        if (file != null && file.exists() && file.isDirectory()) {
            return file.listFiles(new g(z));
        }
        return null;
    }

    public static File c(File[] fileArr) {
        File file = null;
        if (fileArr != null && fileArr.length != 0) {
            int length = fileArr.length;
            int i = 0;
            while (i < length) {
                File file2 = fileArr[i];
                if (file2.lastModified() <= (file != null ? file.lastModified() : 0L)) {
                    file2 = file;
                }
                i++;
                file = file2;
            }
        }
        return file;
    }

    public static File[] c(String str, boolean z) {
        try {
            return b(new File(str), z);
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> f(InputStream inputStream) {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HTTP.UTF_8), 2048);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String trim = readLine.trim();
                    if (!"".equals(trim)) {
                        arrayList.add(trim);
                    }
                } catch (Exception e) {
                    cn.jiguang.g.f.a(bufferedReader);
                    return arrayList;
                } catch (Throwable th) {
                    bufferedReader2 = bufferedReader;
                    th = th;
                    cn.jiguang.g.f.a(bufferedReader2);
                    throw th;
                }
            }
            cn.jiguang.g.f.a(bufferedReader);
        } catch (Exception e2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    private static void f(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable th) {
        }
    }

    public static String g(File file) {
        byte[] h = h(file);
        if (h == null) {
            return null;
        }
        try {
            return new String(h, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static byte[] h(java.io.File r3) {
        /*
            r1 = 0
            if (r3 == 0) goto Lf
            boolean r0 = r3.exists()
            if (r0 == 0) goto Lf
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L11
        Lf:
            r0 = r1
        L10:
            return r0
        L11:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L23
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L23
            int r0 = r2.available()     // Catch: java.lang.Throwable -> L32
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L32
            r2.read(r0)     // Catch: java.lang.Throwable -> L32
            cn.jiguang.g.f.a(r2)
            goto L10
        L23:
            r0 = move-exception
            r0 = r1
        L25:
            cn.jiguang.g.f.a(r0)
            r0 = r1
            goto L10
        L2a:
            r0 = move-exception
            r2 = r1
        L2c:
            cn.jiguang.g.f.a(r2)
            throw r0
        L30:
            r0 = move-exception
            goto L2c
        L32:
            r0 = move-exception
            r0 = r2
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.h.f.h(java.io.File):byte[]");
    }

    public static Object i(File file) {
        ObjectInputStream objectInputStream;
        Throwable th;
        Object obj = null;
        if (file != null && file.exists() && !file.isDirectory()) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
            } catch (Throwable th2) {
                objectInputStream = null;
                th = th2;
            }
            try {
                obj = objectInputStream.readObject();
                cn.jiguang.g.f.a((Closeable) objectInputStream);
            } catch (Throwable th3) {
                th = th3;
                cn.jiguang.g.f.a((Closeable) objectInputStream);
                throw th;
            }
        }
        return obj;
    }

    public static void j(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                j(file2);
                file2.delete();
            }
        }
        file.delete();
    }
}
