package com.baidu.searchbox.live.interfaces.service;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000  2\u00020\u0001:\u0003 !\"J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ/\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u001dJ3\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService;", "Lkotlin/Any;", "", "getFontSizeType", "()I", "Landroid/graphics/Bitmap;", "bitmap", "type", "numRoundPolicy", "getScaledBitmap", "(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", ResourceManager.DRAWABLE, "getScaledDrawable", "(Landroid/graphics/drawable/Drawable;II)Landroid/graphics/drawable/Drawable;", "", "size", "getScaledSize", "(FII)I", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "width", "height", "", "setScaledSize", "(Landroid/view/View;FFII)V", "Landroid/widget/TextView;", Config.TARGET_SDK_VERSION, "unit", "(Landroid/widget/TextView;IFII)V", "setScaledWidth", "(Landroid/view/View;FII)V", "Companion", "FontSizeRoundPolicy", "SizeType", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveFontSizeService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic;
        public static final ServiceReference SERVICE_REFERENCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-674356128, "Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-674356128, "Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_FONT_SIZE);
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SERVICE_REFERENCE : (ServiceReference) invokeV.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$FontSizeRoundPolicy;", "", "NUM_ROUND_POLICY_CEILING", "I", "NUM_ROUND_POLICY_DEFAULT", "NUM_ROUND_POLICY_FLOOR", "NUM_ROUND_POLICY_NEAREST", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class FontSizeRoundPolicy {
        public static /* synthetic */ Interceptable $ic = null;
        public static final FontSizeRoundPolicy INSTANCE;
        public static final int NUM_ROUND_POLICY_CEILING = 0;
        public static final int NUM_ROUND_POLICY_DEFAULT = 2;
        public static final int NUM_ROUND_POLICY_FLOOR = 1;
        public static final int NUM_ROUND_POLICY_NEAREST = 2;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-467684004, "Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$FontSizeRoundPolicy;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-467684004, "Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$FontSizeRoundPolicy;");
                    return;
                }
            }
            INSTANCE = new FontSizeRoundPolicy();
        }

        public FontSizeRoundPolicy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$SizeType;", "", "CONTENT", "I", "FRAMEWORK", "H", "T", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class SizeType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CONTENT = 1;
        public static final int FRAMEWORK = 0;
        public static final int H = 2;
        public static final SizeType INSTANCE;
        public static final int T = 3;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2001485585, "Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$SizeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2001485585, "Lcom/baidu/searchbox/live/interfaces/service/LiveFontSizeService$SizeType;");
                    return;
                }
            }
            INSTANCE = new SizeType();
        }

        public SizeType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    int getFontSizeType();

    Bitmap getScaledBitmap(Bitmap bitmap, int i, int i2);

    Drawable getScaledDrawable(Drawable drawable, int i, int i2);

    int getScaledSize(float f, int i, int i2);

    void setScaledSize(View view2, float f, float f2, int i, int i2);

    void setScaledSize(TextView textView, int i, float f, int i2, int i3);

    void setScaledWidth(View view2, float f, int i, int i2);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ Bitmap getScaledBitmap$default(LiveFontSizeService liveFontSizeService, Bitmap bitmap, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 2;
                }
                return liveFontSizeService.getScaledBitmap(bitmap, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScaledBitmap");
        }

        public static /* synthetic */ Drawable getScaledDrawable$default(LiveFontSizeService liveFontSizeService, Drawable drawable, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 2;
                }
                return liveFontSizeService.getScaledDrawable(drawable, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScaledDrawable");
        }

        public static /* synthetic */ int getScaledSize$default(LiveFontSizeService liveFontSizeService, float f, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = 2;
                }
                return liveFontSizeService.getScaledSize(f, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getScaledSize");
        }

        public static /* synthetic */ void setScaledSize$default(LiveFontSizeService liveFontSizeService, TextView textView, int i, float f, int i2, int i3, int i4, Object obj) {
            if (obj == null) {
                liveFontSizeService.setScaledSize(textView, i, f, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 2 : i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaledSize");
        }

        public static /* synthetic */ void setScaledWidth$default(LiveFontSizeService liveFontSizeService, View view2, float f, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i = 0;
                }
                if ((i3 & 8) != 0) {
                    i2 = 2;
                }
                liveFontSizeService.setScaledWidth(view2, f, i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaledWidth");
        }

        public static /* synthetic */ void setScaledSize$default(LiveFontSizeService liveFontSizeService, View view2, float f, float f2, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                liveFontSizeService.setScaledSize(view2, f, f2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 2 : i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setScaledSize");
        }
    }
}
