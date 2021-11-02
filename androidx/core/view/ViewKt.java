package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a9\u0010\u0007\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\t\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\n\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\n\u0010\b\u001a9\u0010\u000b\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\u000b\u0010\b\u001a9\u0010\r\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a,\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a,\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001e\u0010\u001d\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u001bH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a9\u0010$\u001a\u00020\u0005\"\n\b\u0000\u0010 \u0018\u0001*\u00020\u001f*\u00020\u00002\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b!H\u0087\b¢\u0006\u0004\b#\u0010\b\u001a-\u0010$\u001a\u00020\u0005*\u00020\u00002\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b!H\u0086\b¢\u0006\u0004\b$\u0010\b\u001a<\u0010)\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010%\u001a\u00020\u001b2\b\b\u0003\u0010&\u001a\u00020\u001b2\b\b\u0003\u0010'\u001a\u00020\u001b2\b\b\u0003\u0010(\u001a\u00020\u001bH\u0086\b¢\u0006\u0004\b)\u0010*\u001a<\u0010-\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010+\u001a\u00020\u001b2\b\b\u0003\u0010&\u001a\u00020\u001b2\b\b\u0003\u0010,\u001a\u00020\u001b2\b\b\u0003\u0010(\u001a\u00020\u001bH\u0087\b¢\u0006\u0004\b-\u0010*\"*\u00100\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103\"*\u00104\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00101\"\u0004\b5\u00103\"*\u00106\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00101\"\u0004\b7\u00103\"\u0018\u0010:\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0018\u0010<\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b;\u00109\"\u0018\u0010>\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b=\u00109\"\u0018\u0010@\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b?\u00109\"\u0018\u0010B\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bA\u00109\"\u0018\u0010D\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bC\u00109¨\u0006E"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "action", "doOnAttach", "(Landroid/view/View;Lkotlin/Function1;)V", "doOnDetach", "doOnLayout", "doOnNextLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "(Landroid/view/View;Lkotlin/Function1;)Landroidx/core/view/OneShotPreDrawListener;", "Landroid/graphics/Bitmap$Config;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Landroid/graphics/Bitmap;", "drawToBitmap", "(Landroid/view/View;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/view/View;JLkotlin/Function0;)Ljava/lang/Runnable;", "postOnAnimationDelayed", "", "size", "setPadding", "(Landroid/view/View;I)V", "Landroid/view/ViewGroup$LayoutParams;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "updateLayoutParamsTyped", "updateLayoutParams", "left", VerticalTranslateLayout.TOP, HorizontalTranslateLayout.RIGHT, "bottom", "updatePadding", "(Landroid/view/View;IIII)V", "start", "end", "updatePaddingRelative", "", "value", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "getMarginBottom", "(Landroid/view/View;)I", "marginBottom", "getMarginEnd", "marginEnd", "getMarginLeft", "marginLeft", "getMarginRight", "marginRight", "getMarginStart", "marginStart", "getMarginTop", "marginTop", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ViewKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void doOnAttach(final View view, final Function1<? super View, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, view, function1) == null) {
            if (ViewCompat.isAttachedToWindow(view)) {
                function1.invoke(view);
            } else {
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, function1) { // from class: androidx.core.view.ViewKt$doOnAttach$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Function1 $action;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View $this_doOnAttach;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {view, function1};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$this_doOnAttach = view;
                        this.$action = function1;
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
                            this.$action.invoke(view2);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        }
                    }
                });
            }
        }
    }

    public static final void doOnDetach(final View view, final Function1<? super View, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, view, function1) == null) {
            if (!ViewCompat.isAttachedToWindow(view)) {
                function1.invoke(view);
            } else {
                view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(view, function1) { // from class: androidx.core.view.ViewKt$doOnDetach$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Function1 $action;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View $this_doOnDetach;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {view, function1};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$this_doOnDetach = view;
                        this.$action = function1;
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                            this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
                            this.$action.invoke(view2);
                        }
                    }
                });
            }
        }
    }

    public static final void doOnLayout(View view, final Function1<? super View, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view, function1) == null) {
            if (ViewCompat.isLaidOut(view) && !view.isLayoutRequested()) {
                function1.invoke(view);
            } else {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(function1) { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Function1 $action$inlined;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {function1};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$action$inlined = function1;
                    }

                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                            view2.removeOnLayoutChangeListener(this);
                            this.$action$inlined.invoke(view2);
                        }
                    }
                });
            }
        }
    }

    public static final void doOnNextLayout(View view, final Function1<? super View, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view, function1) == null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener(function1) { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function1 $action;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$action = function1;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)}) == null) {
                        view2.removeOnLayoutChangeListener(this);
                        this.$action.invoke(view2);
                    }
                }
            });
        }
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view, final Function1<? super View, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view, function1)) == null) {
            OneShotPreDrawListener add = OneShotPreDrawListener.add(view, new Runnable(view, function1) { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function1 $action;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View $this_doOnPreDraw;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view, function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$this_doOnPreDraw = view;
                    this.$action = function1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.$action.invoke(this.$this_doOnPreDraw);
                    }
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(add, "OneShotPreDrawListener.add(this) { action(this) }");
            return add;
        }
        return (OneShotPreDrawListener) invokeLL.objValue;
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, view, config)) == null) {
            if (ViewCompat.isLaidOut(view)) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
                Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
                Canvas canvas = new Canvas(createBitmap);
                canvas.translate(-view.getScrollX(), -view.getScrollY());
                view.draw(canvas);
                return createBitmap;
            }
            throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final int getMarginBottom(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                return marginLayoutParams.bottomMargin;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int getMarginEnd(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int getMarginLeft(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                return marginLayoutParams.leftMargin;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int getMarginRight(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                return marginLayoutParams.rightMargin;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int getMarginStart(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int getMarginTop(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                return marginLayoutParams.topMargin;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final boolean isGone(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view)) == null) ? view.getVisibility() == 8 : invokeL.booleanValue;
    }

    public static final boolean isInvisible(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, view)) == null) ? view.getVisibility() == 4 : invokeL.booleanValue;
    }

    public static final boolean isVisible(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, view)) == null) ? view.getVisibility() == 0 : invokeL.booleanValue;
    }

    public static final Runnable postDelayed(View view, long j, final Function0<Unit> function0) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{view, Long.valueOf(j), function0})) == null) {
            Runnable runnable = new Runnable(function0) { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function0 $action;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function0};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$action = function0;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.$action.invoke();
                    }
                }
            };
            view.postDelayed(runnable, j);
            return runnable;
        }
        return (Runnable) invokeCommon.objValue;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view, long j, final Function0<Unit> function0) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{view, Long.valueOf(j), function0})) == null) {
            Runnable runnable = new Runnable(function0) { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function0 $action;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function0};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$action = function0;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.$action.invoke();
                    }
                }
            };
            view.postOnAnimationDelayed(runnable, j);
            return runnable;
        }
        return (Runnable) invokeCommon.objValue;
    }

    public static final void setGone(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65554, null, view, z) == null) {
            view.setVisibility(z ? 8 : 0);
        }
    }

    public static final void setInvisible(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65555, null, view, z) == null) {
            view.setVisibility(z ? 4 : 0);
        }
    }

    public static final void setPadding(View view, @Px int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, view, i2) == null) {
            view.setPadding(i2, i2, i2, i2);
        }
    }

    public static final void setVisible(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, view, z) == null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public static final void updateLayoutParams(View view, Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, view, function1) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                function1.invoke(layoutParams);
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, Function1<? super T, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        function1.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static /* synthetic */ void updatePadding$default(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingLeft();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingRight();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        view.setPadding(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            view.setPaddingRelative(i2, i3, i4, i5);
        }
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingStart();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i2, i3, i4, i5);
    }
}
