package b.a.p0.a.a0.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import b.a.p0.a.k;
import b.a.p0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public String u;
    public float v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = "png";
        this.v = 1.0f;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.o = n0.g((float) jSONObject.optDouble("x"));
            this.p = n0.g((float) jSONObject.optDouble("y"));
            this.q = n0.g((float) jSONObject.optDouble("width"));
            this.r = n0.g((float) jSONObject.optDouble("height"));
            this.s = n0.g((float) jSONObject.optDouble("destWidth"));
            this.t = n0.g((float) jSONObject.optDouble("destHeight"));
            this.u = jSONObject.optString("fileType");
            this.v = (float) jSONObject.optDouble("quality");
        } catch (Exception e2) {
            if (k.f6863a) {
                e2.printStackTrace();
            }
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.equals(this.u, "jpg") : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.a0.b.a, b.a.p0.a.c0.b.b, b.a.p0.a.m1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q > 0 && this.r > 0 : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bc A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d2 A[Catch: OutOfMemoryError -> 0x00f3, Exception -> 0x00fc, TryCatch #2 {Exception -> 0x00fc, OutOfMemoryError -> 0x00f3, blocks: (B:9:0x000f, B:11:0x0027, B:14:0x002c, B:16:0x0030, B:18:0x0036, B:21:0x003b, B:23:0x003f, B:25:0x0045, B:28:0x004d, B:30:0x0053, B:32:0x0059, B:35:0x0061, B:37:0x0068, B:39:0x006e, B:41:0x0073, B:43:0x0079, B:45:0x007e, B:47:0x00b9, B:49:0x00be, B:51:0x00c9, B:52:0x00cc, B:54:0x00d2, B:55:0x00d9, B:48:0x00bc, B:44:0x007c, B:40:0x0071, B:36:0x0064, B:29:0x0050), top: B:71:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean j(View view, String str) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        int i4;
        int i5;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, str)) == null) {
            if (view != null && !TextUtils.isEmpty(str)) {
                try {
                    Bitmap x = n0.x(view, view.getWidth(), view.getHeight());
                    int width = x.getWidth();
                    int height = x.getHeight();
                    if (this.o >= 0 && this.o < width) {
                        i2 = this.o;
                        this.o = i2;
                        if (this.p >= 0 && this.p < height) {
                            i3 = this.p;
                            this.p = i3;
                            if (this.q > 0 && this.o + this.q <= width) {
                                i4 = this.q;
                                this.q = i4;
                                if (this.r > 0 && this.p + this.r <= height) {
                                    i5 = this.r;
                                    this.r = i5;
                                    this.s = this.s > 0 ? this.q : this.s;
                                    int i6 = this.t > 0 ? this.r : this.t;
                                    this.t = i6;
                                    Bitmap createBitmap = Bitmap.createBitmap(this.s, i6, x.getConfig());
                                    new Canvas(createBitmap).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                                    Bitmap.CompressFormat compressFormat = !i() ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
                                    file = new File(str);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    if (file.getParentFile() != null) {
                                        file.getParentFile().mkdirs();
                                    }
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    createBitmap.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream);
                                    fileOutputStream.flush();
                                    b.a.p0.w.d.d(fileOutputStream);
                                    return true;
                                }
                                i5 = height - this.p;
                                this.r = i5;
                                this.s = this.s > 0 ? this.q : this.s;
                                if (this.t > 0) {
                                }
                                this.t = i6;
                                Bitmap createBitmap2 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                                new Canvas(createBitmap2).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                                if (!i()) {
                                }
                                file = new File(str);
                                if (file.exists()) {
                                }
                                if (file.getParentFile() != null) {
                                }
                                file.createNewFile();
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                createBitmap2.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream2);
                                fileOutputStream2.flush();
                                b.a.p0.w.d.d(fileOutputStream2);
                                return true;
                            }
                            i4 = width - this.o;
                            this.q = i4;
                            if (this.r > 0) {
                                i5 = this.r;
                                this.r = i5;
                                this.s = this.s > 0 ? this.q : this.s;
                                if (this.t > 0) {
                                }
                                this.t = i6;
                                Bitmap createBitmap22 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                                new Canvas(createBitmap22).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                                if (!i()) {
                                }
                                file = new File(str);
                                if (file.exists()) {
                                }
                                if (file.getParentFile() != null) {
                                }
                                file.createNewFile();
                                FileOutputStream fileOutputStream22 = new FileOutputStream(file);
                                createBitmap22.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream22);
                                fileOutputStream22.flush();
                                b.a.p0.w.d.d(fileOutputStream22);
                                return true;
                            }
                            i5 = height - this.p;
                            this.r = i5;
                            this.s = this.s > 0 ? this.q : this.s;
                            if (this.t > 0) {
                            }
                            this.t = i6;
                            Bitmap createBitmap222 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                            new Canvas(createBitmap222).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                            if (!i()) {
                            }
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (file.getParentFile() != null) {
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream222 = new FileOutputStream(file);
                            createBitmap222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream222);
                            fileOutputStream222.flush();
                            b.a.p0.w.d.d(fileOutputStream222);
                            return true;
                        }
                        i3 = 0;
                        this.p = i3;
                        if (this.q > 0) {
                            i4 = this.q;
                            this.q = i4;
                            if (this.r > 0) {
                            }
                            i5 = height - this.p;
                            this.r = i5;
                            this.s = this.s > 0 ? this.q : this.s;
                            if (this.t > 0) {
                            }
                            this.t = i6;
                            Bitmap createBitmap2222 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                            new Canvas(createBitmap2222).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                            if (!i()) {
                            }
                            file = new File(str);
                            if (file.exists()) {
                            }
                            if (file.getParentFile() != null) {
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream2222 = new FileOutputStream(file);
                            createBitmap2222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream2222);
                            fileOutputStream2222.flush();
                            b.a.p0.w.d.d(fileOutputStream2222);
                            return true;
                        }
                        i4 = width - this.o;
                        this.q = i4;
                        if (this.r > 0) {
                        }
                        i5 = height - this.p;
                        this.r = i5;
                        this.s = this.s > 0 ? this.q : this.s;
                        if (this.t > 0) {
                        }
                        this.t = i6;
                        Bitmap createBitmap22222 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                        new Canvas(createBitmap22222).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                        if (!i()) {
                        }
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (file.getParentFile() != null) {
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream22222 = new FileOutputStream(file);
                        createBitmap22222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream22222);
                        fileOutputStream22222.flush();
                        b.a.p0.w.d.d(fileOutputStream22222);
                        return true;
                    }
                    i2 = 0;
                    this.o = i2;
                    if (this.p >= 0) {
                        i3 = this.p;
                        this.p = i3;
                        if (this.q > 0) {
                        }
                        i4 = width - this.o;
                        this.q = i4;
                        if (this.r > 0) {
                        }
                        i5 = height - this.p;
                        this.r = i5;
                        this.s = this.s > 0 ? this.q : this.s;
                        if (this.t > 0) {
                        }
                        this.t = i6;
                        Bitmap createBitmap222222 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                        new Canvas(createBitmap222222).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                        if (!i()) {
                        }
                        file = new File(str);
                        if (file.exists()) {
                        }
                        if (file.getParentFile() != null) {
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream222222 = new FileOutputStream(file);
                        createBitmap222222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream222222);
                        fileOutputStream222222.flush();
                        b.a.p0.w.d.d(fileOutputStream222222);
                        return true;
                    }
                    i3 = 0;
                    this.p = i3;
                    if (this.q > 0) {
                    }
                    i4 = width - this.o;
                    this.q = i4;
                    if (this.r > 0) {
                    }
                    i5 = height - this.p;
                    this.r = i5;
                    this.s = this.s > 0 ? this.q : this.s;
                    if (this.t > 0) {
                    }
                    this.t = i6;
                    Bitmap createBitmap2222222 = Bitmap.createBitmap(this.s, i6, x.getConfig());
                    new Canvas(createBitmap2222222).drawBitmap(x, new Rect(this.o, this.p, this.o + this.q, this.p + this.r), new Rect(0, 0, this.s, this.t), new Paint());
                    if (!i()) {
                    }
                    file = new File(str);
                    if (file.exists()) {
                    }
                    if (file.getParentFile() != null) {
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2222222 = new FileOutputStream(file);
                    createBitmap2222222.compress(compressFormat, (int) (this.v * 100.0f), fileOutputStream2222222);
                    fileOutputStream2222222.flush();
                    b.a.p0.w.d.d(fileOutputStream2222222);
                    return true;
                } catch (Exception e2) {
                    if (k.f6863a) {
                        e2.printStackTrace();
                    }
                } catch (OutOfMemoryError e3) {
                    if (k.f6863a) {
                        e3.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
