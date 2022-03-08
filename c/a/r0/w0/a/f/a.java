package c.a.r0.w0.a.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import c.a.y0.l.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.RecordConstants;
/* loaded from: classes3.dex */
public abstract class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.w0.a.g.b a;

    /* renamed from: b  reason: collision with root package name */
    public e f24333b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f24334c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24335d;

    /* renamed from: c.a.r0.w0.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1496a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24336e;

        public RunnableC1496a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24336e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24336e.f();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24335d = false;
    }

    @Override // c.a.r0.w0.a.f.d
    public void a(c.a.r0.w0.a.g.b bVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bVar, eVar) == null) || eVar == null) {
            return;
        }
        this.f24333b = eVar;
        if (bVar == null) {
            eVar.onError(StringUtil.NULL_STRING, "cover config is null !!");
            return;
        }
        this.a = bVar;
        this.f24334c = new Thread(new RunnableC1496a(this));
        ThreadPool.b().e(this.f24334c);
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.w0.a.g.b bVar = this.a;
            int[] iArr = {bVar.a, bVar.f24337b};
            if (!bVar.f24342g && !bVar.f24340e) {
                float f2 = bVar.f24339d;
                if (f2 != 0.0f) {
                    a.C1616a e2 = c.a.y0.l.a.e(f2, RecordConstants.VIDEO_CONSTANT_WIDTH);
                    iArr[0] = e2.b();
                    iArr[1] = e2.a();
                }
            } else {
                a.C1616a e3 = e();
                float f3 = this.a.f24339d;
                if (f3 != 0.0f) {
                    a.C1616a f4 = c.a.y0.l.a.f(f3, e3.b(), e3.a());
                    iArr[0] = f4.b();
                    iArr[1] = f4.a();
                }
                a.C1616a d2 = c.a.y0.l.a.d(iArr[0], iArr[1]);
                iArr[0] = d2.b();
                iArr[1] = d2.a();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public Bitmap c(Bitmap bitmap, float f2, MultiMediaData multiMediaData) {
        InterceptResult invokeCommon;
        Bitmap bitmap2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Float.valueOf(f2), multiMediaData})) == null) {
            if (multiMediaData == null || !((i2 = 360 - (((int) multiMediaData.angle) % 360)) == 90 || i2 == 270)) {
                bitmap2 = null;
            } else {
                Matrix matrix = new Matrix();
                matrix.setRotate(i2);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            if (bitmap2 != null) {
                bitmap = bitmap2;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (bitmap.getHeight() / bitmap.getWidth() > f2) {
                width = (int) (bitmap.getHeight() * f2);
            } else {
                height = (int) (bitmap.getWidth() * f2);
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            canvas.save();
            canvas.drawBitmap(bitmap, width != bitmap.getWidth() ? Math.abs(width - bitmap.getWidth()) / 2 : 0, height != bitmap.getHeight() ? Math.abs(height - bitmap.getHeight()) / 2 : 0, (Paint) null);
            canvas.restore();
            bitmap.recycle();
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public String d(int i2, int i3, Bitmap bitmap, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bitmap, Boolean.valueOf(z)})) == null) {
            if (i2 == 0 || i3 == 0) {
                return "";
            }
            Bitmap h2 = c.a.y0.r.d.h(bitmap, i2, i3, z);
            String b2 = this.f24335d ? c.a.r0.o4.m.d.b.b() : c.a.r0.o4.m.d.b.a();
            String c2 = c.a.r0.o4.m.d.b.c(b2, h2, System.currentTimeMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
            if (h2 != null) {
                h2.recycle();
                return c2;
            }
            return c2;
        }
        return (String) invokeCommon.objValue;
    }

    public a.C1616a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MultiMediaData multiMediaData = this.a.f24338c;
            int i2 = RecordConstants.VIDEO_CONSTANT_WIDTH;
            int i3 = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            if (multiMediaData == null) {
                return new a.C1616a(i2, i3);
            }
            if (multiMediaData.type == 1) {
                float f2 = multiMediaData.angle;
                float f3 = multiMediaData.rotation;
                if ((f2 + f3) % 360.0f != 90.0f && (f2 + f3) % 360.0f != 270.0f) {
                    i2 = multiMediaData.width;
                    i3 = multiMediaData.height;
                } else {
                    i2 = multiMediaData.height;
                    i3 = multiMediaData.width;
                }
            }
            return new a.C1616a(i2, i3);
        }
        return (a.C1616a) invokeV.objValue;
    }

    public abstract void f();

    public void g(c.a.r0.w0.a.g.a aVar, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, aVar, bitmap) == null) {
            if (aVar == null) {
                aVar = new c.a.r0.w0.a.g.a();
            }
            int[] b2 = b();
            aVar.a = d(b2[0], b2[1], bitmap, true);
            this.f24333b.a(this.a.f24341f, aVar);
        }
    }
}
