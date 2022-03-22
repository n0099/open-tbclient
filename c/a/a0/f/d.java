package c.a.a0.f;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.h0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.clickinfo.NadTouchInfoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NadTouchInfoModel a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<c> f1160b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<View> f1161c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f1162d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1163e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1164f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1165g;

    public d(@NonNull b bVar, @NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1162d = c.a.a0.h.a.b();
        this.f1161c = new WeakReference<>(view);
        this.f1160b = new WeakReference<>(bVar.getTouchInfoCollector());
        DisplayMetrics displayMetrics = this.f1162d.getResources().getDisplayMetrics();
        this.f1163e = displayMetrics.widthPixels;
        this.f1164f = displayMetrics.heightPixels;
        this.f1165g = displayMetrics.densityDpi;
        this.a = new NadTouchInfoModel(-1);
        d();
    }

    @NonNull
    public static a b(@Nullable a aVar, @NonNull b bVar, @NonNull View view) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, aVar, bVar, view)) == null) {
            if (aVar == null) {
                return new d(bVar, view);
            }
            d dVar = (d) aVar;
            if (dVar.f1161c.get() == null) {
                dVar.f1161c = new WeakReference<>(view);
            }
            if (dVar.f1160b.get() == null) {
                dVar.f1160b = new WeakReference<>(bVar.getTouchInfoCollector());
            }
            return dVar;
        }
        return (a) invokeLLL.objValue;
    }

    @Override // c.a.a0.f.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = this.f1160b.get();
            if (cVar == null) {
                return "";
            }
            int[] b2 = cVar.b();
            int[] iArr = new int[2];
            View view = this.f1161c.get();
            if (view != null) {
                view.getLocationOnScreen(iArr);
            }
            int i = iArr[1];
            int height = view != null ? view.getHeight() + i : 0;
            Point c2 = c();
            int i2 = this.f1163e;
            int i3 = this.f1164f;
            if (c2 != null) {
                i2 = c2.x;
                i3 = c2.y;
            }
            String[] strArr = new String[9];
            strArr[0] = DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX;
            strArr[1] = f.c.j() ? "1" : "0";
            strArr[2] = String.valueOf(b2[0]);
            strArr[3] = String.valueOf(b2[1]);
            strArr[4] = String.valueOf(i);
            strArr[5] = String.valueOf(height);
            strArr[6] = String.valueOf(i2);
            strArr[7] = String.valueOf(i3);
            strArr[8] = String.valueOf(this.f1165g);
            return TextUtils.join(",", strArr);
        }
        return (String) invokeV.objValue;
    }

    public final Point c() {
        InterceptResult invokeV;
        Display display;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.f1161c.get();
            if (view == null || Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
                return null;
            }
            Point point = new Point();
            display.getRealSize(point);
            return point;
        }
        return (Point) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NadTouchInfoModel nadTouchInfoModel = this.a;
            if (nadTouchInfoModel.f27493b) {
                return;
            }
            nadTouchInfoModel.a = this.f1165g;
            nadTouchInfoModel.f27493b = true;
        }
    }
}
