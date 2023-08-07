package com.baidu.searchbox.ui.floatbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.floatbar.BottomFloatToolBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/ui/floatbar/BottomFloatToolBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mClickListeners", "Lcom/baidu/searchbox/ui/floatbar/IBottomFloatToolBarClickListener;", "onAttachedToWindow", "", "onDetachedFromWindow", "onFontSizeChange", "onNightModeChange", "runOnUIThread", "runnable", "Ljava/lang/Runnable;", "setClickListener", "clickListener", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomFloatToolBar extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    public volatile IBottomFloatToolBarClickListener mClickListeners;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i));
        if (view2 == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomFloatToolBar(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.new_home_float_bar_layout, (ViewGroup) this, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.co1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        BottomFloatToolBar.m106_init_$lambda0(BottomFloatToolBar.this, view2);
                    }
                }
            });
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView3 != null) {
            imageView3.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ao1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        BottomFloatToolBar.m107_init_$lambda1(BottomFloatToolBar.this, view2);
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomFloatToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.new_home_float_bar_layout, (ViewGroup) this, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.co1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        BottomFloatToolBar.m106_init_$lambda0(BottomFloatToolBar.this, view2);
                    }
                }
            });
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView3 != null) {
            imageView3.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ao1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        BottomFloatToolBar.m107_init_$lambda1(BottomFloatToolBar.this, view2);
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomFloatToolBar(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(R.layout.new_home_float_bar_layout, (ViewGroup) this, true);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.co1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        BottomFloatToolBar.m106_init_$lambda0(BottomFloatToolBar.this, view2);
                    }
                }
            });
        }
        ImageView imageView3 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView3 != null) {
            imageView3.setOnTouchListener(new BottomFloatButtonTouchStateListener());
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ao1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        BottomFloatToolBar.m107_init_$lambda1(BottomFloatToolBar.this, view2);
                    }
                }
            });
        }
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m106_init_$lambda0(BottomFloatToolBar this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IBottomFloatToolBarClickListener iBottomFloatToolBarClickListener = this$0.mClickListeners;
        if (iBottomFloatToolBarClickListener != null) {
            iBottomFloatToolBarClickListener.onBackButtonClick();
        }
    }

    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m107_init_$lambda1(BottomFloatToolBar this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IBottomFloatToolBarClickListener iBottomFloatToolBarClickListener = this$0.mClickListeners;
        if (iBottomFloatToolBarClickListener != null) {
            iBottomFloatToolBarClickListener.onMenuButtonClick();
        }
    }

    /* renamed from: onAttachedToWindow$lambda-3  reason: not valid java name */
    public static final void m108onAttachedToWindow$lambda3(BottomFloatToolBar this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onNightModeChange();
    }

    /* renamed from: onAttachedToWindow$lambda-4  reason: not valid java name */
    public static final void m109onAttachedToWindow$lambda4(BottomFloatToolBar this$0, FontSizeChangeMessage it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.onFontSizeChange();
    }

    /* renamed from: setClickListener$lambda-2  reason: not valid java name */
    public static final void m112setClickListener$lambda2(BottomFloatToolBar this$0, IBottomFloatToolBarClickListener iBottomFloatToolBarClickListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mClickListeners = iBottomFloatToolBarClickListener;
    }

    private final void onFontSizeChange() {
        runOnUIThread(new Runnable() { // from class: com.baidu.tieba.bo1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    BottomFloatToolBar.m110onFontSizeChange$lambda6(BottomFloatToolBar.this);
                }
            }
        });
    }

    private final void onNightModeChange() {
        runOnUIThread(new Runnable() { // from class: com.baidu.tieba.yn1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    BottomFloatToolBar.m111onNightModeChange$lambda5(BottomFloatToolBar.this);
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onNightModeChange();
        onFontSizeChange();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.tieba.xn1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public final void onNightModeChanged(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    BottomFloatToolBar.m108onAttachedToWindow$lambda3(BottomFloatToolBar.this, z);
                }
            }
        });
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action() { // from class: com.baidu.tieba.wn1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.searchbox.bdeventbus.Action
            public final void call(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    BottomFloatToolBar.m109onAttachedToWindow$lambda4(BottomFloatToolBar.this, (FontSizeChangeMessage) obj);
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        BdEventBus.Companion.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    /* renamed from: onFontSizeChange$lambda-6  reason: not valid java name */
    public static final void m110onFontSizeChange$lambda6(BottomFloatToolBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            FontSizeViewExtKt.setScaledSizeRes$default(imageView, 2, R.dimen.new_home_float_bar_width, R.dimen.new_home_float_bar_height, 0, 8, null);
        }
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView2 != null) {
            FontSizeViewExtKt.setScaledSizeRes$default(imageView2, 2, R.dimen.new_home_float_bar_width, R.dimen.new_home_float_bar_height, 0, 8, null);
        }
    }

    /* renamed from: onNightModeChange$lambda-5  reason: not valid java name */
    public static final void m111onNightModeChange$lambda5(BottomFloatToolBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarBackImageView);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this$0.getContext(), R.drawable.new_home_float_bar_back));
        }
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(R.id.newHomeFloatBarFunctionImageView);
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(this$0.getContext(), R.drawable.new_home_float_bar_function));
        }
    }

    private final void runOnUIThread(Runnable runnable) {
        if (UiThreadUtils.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtils.runOnUiThread(runnable);
        }
    }

    public final void setClickListener(final IBottomFloatToolBarClickListener iBottomFloatToolBarClickListener) {
        runOnUIThread(new Runnable() { // from class: com.baidu.tieba.zn1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    BottomFloatToolBar.m112setClickListener$lambda2(BottomFloatToolBar.this, iBottomFloatToolBarClickListener);
                }
            }
        });
    }
}
