package com.baidu.helios.channels.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.media.MimeType;
import com.baidu.down.request.taskmanager.DatabaseMng;
import com.baidu.helios.channels.a;
import com.baidu.helios.common.c.a;
import com.baidu.mobstat.Config;
import java.io.Closeable;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends com.baidu.helios.channels.a {
    a.C0149a avX;
    private C0146b awD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a {
        private int d;
        private String e;

        a() {
        }

        static a fA(String str) {
            JSONObject jSONObject = new JSONObject(new String(new com.baidu.helios.common.a.b().B(Base64.decode(str, 3))));
            a aVar = new a();
            aVar.a(jSONObject.getString("id"));
            aVar.a(jSONObject.getInt("d_form_ver"));
            return aVar;
        }

        String a() {
            return this.e;
        }

        void a(int i) {
            this.d = i;
        }

        void a(String str) {
            this.e = str;
        }

        String b() {
            if (this.e == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            com.baidu.helios.common.a.b bVar = new com.baidu.helios.common.a.b();
            jSONObject.put("id", this.e);
            jSONObject.put("d_form_ver", 1);
            return Base64.encodeToString(bVar.A(jSONObject.toString().getBytes()), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.channels.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0146b {
        private int g;
        private long h;
        private String i;
        private boolean j;

        C0146b() {
        }

        private boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.h = jSONObject.getLong("pub_lst_ts");
                this.i = jSONObject.getString("pub_id");
                this.g = jSONObject.getInt("d_form_ver");
                this.j = false;
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        String a() {
            return this.i;
        }

        void a(long j) {
            if (this.h != j) {
                this.h = j;
                this.j = true;
            }
        }

        void a(String str) {
            if (str.equals(this.i)) {
                return;
            }
            this.i = str;
            this.j = true;
        }

        boolean b() {
            return b(b.this.avX.p("pub.dat", true));
        }

        boolean c() {
            if (this.j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.i);
                    jSONObject.put("pub_lst_ts", this.h);
                    jSONObject.put("d_form_ver", 1);
                    b.this.avX.d("pub.dat", jSONObject.toString(), true);
                    this.j = false;
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes9.dex */
    class c extends a.b {
        private int h;
        private String i;
        private long j;
        private long k;
        private String l;

        public c(String str) {
            super(b.this.avX, str);
        }

        String a() {
            return this.i;
        }

        boolean a(long j) {
            if (this.j != j) {
                this.j = j;
                aY(true);
                return true;
            }
            return false;
        }

        boolean a(String str) {
            if (str.equals(this.i)) {
                return false;
            }
            this.i = str;
            aY(true);
            return true;
        }

        String b() {
            return this.l;
        }

        boolean b(long j) {
            if (this.k != j) {
                this.k = j;
                aY(true);
                return true;
            }
            return false;
        }

        boolean b(String str) {
            if (str.equals(this.l)) {
                return false;
            }
            this.l = str;
            aY(true);
            return true;
        }

        long c() {
            return this.k;
        }

        @Override // com.baidu.helios.channels.a.b
        public void j(JSONObject jSONObject) {
            this.i = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.j = jSONObject.getLong("last_fe_ts");
            this.l = jSONObject.getString("id");
            this.k = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.h = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void k(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.i);
            jSONObject.put("last_fe_ts", this.j);
            jSONObject.put("id", this.l);
            jSONObject.put("tar_pkg_lst_up_ts", this.k);
            jSONObject.put("d_form_ver", 1);
        }
    }

    public b() {
        super("esc-ms", 7500000L);
        this.awD = new C0146b();
    }

    private Uri a(String str, ContentResolver contentResolver, String str2) {
        int i = 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "helios-icon.JPG");
        contentValues.put("mime_type", MimeType.Image.JPEG);
        contentValues.put("is_pending", (Integer) 1);
        contentValues.put("relative_path", String.format("Pictures/%s/helios", str));
        contentValues.put("description", str2);
        while (true) {
            try {
                Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    throw new IllegalStateException("file path maybe duplicated");
                    break;
                }
                return insert;
            } catch (IllegalStateException e) {
                i++;
                if (i > 5) {
                    throw new IllegalStateException("insert file retry count exceed", e);
                }
                contentValues.put("_display_name", "helios-icon-" + i + ".JPG");
            }
        }
    }

    private void a(OutputStream outputStream, Context context) {
        Drawable loadIcon = context.getApplicationInfo().loadIcon(context.getPackageManager());
        int intrinsicWidth = loadIcon.getIntrinsicWidth();
        int intrinsicHeight = loadIcon.getIntrinsicHeight();
        Matrix matrix = new Matrix();
        Bitmap createBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
        float min = (intrinsicWidth > 96 || intrinsicHeight > 96) ? Math.min(96 / intrinsicWidth, 96 / intrinsicHeight) : 1.0f;
        matrix.setScale(min, min);
        matrix.postTranslate(Math.round((96 - (intrinsicWidth * min)) * 0.5f), Math.round((96 - (intrinsicHeight * min)) * 0.5f));
        Canvas canvas = new Canvas(createBitmap);
        canvas.concat(matrix);
        loadIcon.setBounds(0, 0, loadIcon.getIntrinsicWidth(), loadIcon.getIntrinsicHeight());
        loadIcon.draw(canvas);
        createBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
        createBitmap.recycle();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0037 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.io.Closeable */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.Closeable */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.io.Closeable */
    /* JADX WARN: Multi-variable type inference failed */
    private a.e b(a.d dVar) {
        OutputStream outputStream;
        a.e i;
        Closeable closeable = null;
        Context context = this.awn.applicationContext;
        String packageName = context.getPackageName();
        ContentResolver contentResolver = this.awn.applicationContext.getContentResolver();
        String zT = this.awn.awr.fC("aid").zT();
        String a2 = this.awD.a();
        if (a2 != null && TextUtils.equals(a2, zT)) {
            return a.e.zs();
        }
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return a.e.zt();
            }
            try {
                a aVar = new a();
                aVar.a(zT);
                outputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentResolver.openFileDescriptor(a(packageName, contentResolver, aVar.b()), "w", null));
                try {
                    a(outputStream, context);
                    this.awD.a(zT);
                    this.awD.a(System.currentTimeMillis());
                    i = a.e.zs();
                    com.baidu.helios.common.b.a.c.b(outputStream);
                    packageName = outputStream;
                } catch (Exception e) {
                    e = e;
                    i = a.e.i(e);
                    com.baidu.helios.common.b.a.c.b(outputStream);
                    packageName = outputStream;
                    return i;
                }
            } catch (Exception e2) {
                e = e2;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                com.baidu.helios.common.b.a.c.b(closeable);
                throw th;
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
            closeable = packageName;
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.e.zt();
        }
        this.awD.b();
        try {
            return b(dVar);
        } finally {
            this.awD.c();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0140 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        PackageInfo packageInfo;
        c cVar;
        Cursor cursor;
        if (Build.VERSION.SDK_INT < 29) {
            return a.g.dr(-101);
        }
        Context context = this.awn.applicationContext;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.g.dr(-1);
        }
        if (fVar.useCache) {
            c cVar2 = new c(str);
            cVar2.zq();
            if (str.equals(cVar2.a()) && packageInfo.lastUpdateTime == cVar2.c()) {
                String b = cVar2.b();
                if (!TextUtils.isEmpty(b)) {
                    return a.g.fz(b);
                }
            }
            cVar = cVar2;
        } else {
            cVar = null;
        }
        if (!(context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0)) {
            return a.g.dr(-100);
        }
        ContentResolver contentResolver = context.getContentResolver();
        ?? includePending = MediaStore.setIncludePending(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        try {
            try {
                cursor = contentResolver.query(includePending, new String[]{IMConstants.MSG_ROW_ID, "description"}, "owner_package_name = ? AND relative_path = ?", new String[]{str, "Pictures/" + str + "/helios/"}, DatabaseMng.DEFAULT_SORT_ORDER);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                            if (string != null) {
                                try {
                                    String a2 = a.fA(string).a();
                                    if (!TextUtils.isEmpty(a2)) {
                                        if (fVar.useCache && cVar != null) {
                                            cVar.b(a2);
                                            cVar.a(System.currentTimeMillis());
                                            cVar.b(packageInfo.lastUpdateTime);
                                            cVar.a(str);
                                        }
                                        a.g fz = a.g.fz(a2);
                                        com.baidu.helios.common.b.a.c.b(cursor);
                                        if (!fVar.useCache || cVar == null) {
                                            return fz;
                                        }
                                        cVar.zr();
                                        return fz;
                                    }
                                    continue;
                                } catch (Exception e2) {
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            a.g j = a.g.j(e);
                            com.baidu.helios.common.b.a.c.b(cursor);
                            if (!fVar.useCache || cVar == null) {
                                return j;
                            }
                            cVar.zr();
                            return j;
                        }
                    }
                }
                com.baidu.helios.common.b.a.c.b(cursor);
                if (fVar.useCache && cVar != null) {
                    cVar.zr();
                }
                return a.g.dr(-2);
            } catch (Throwable th) {
                th = th;
                com.baidu.helios.common.b.a.c.b((Cursor) includePending);
                if (fVar.useCache && cVar != null) {
                    cVar.zr();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            includePending = 0;
            com.baidu.helios.common.b.a.c.b((Cursor) includePending);
            if (fVar.useCache) {
                cVar.zr();
            }
            throw th;
        }
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.avX = this.awo.fB("esc-ms");
    }
}
