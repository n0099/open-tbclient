package com.baidu.nadcore.player.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.k0.m;
import c.a.c0.k0.n;
import c.a.c0.v.v0.d;
import c.a.c0.v.z.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.widget.BdThumbSeekBarView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/baidu/nadcore/player/widget/BdPlayerSeekBar;", "Landroid/widget/FrameLayout;", "", "inflate", "()V", "", "bufferingPos", "setBufferingPosition", "(I)V", "duration", "setDuration", "position", "setPosition", "switchToFull", "switchToHalf", "pos", "dur", "buffer", "syncPos", "(III)V", "Lcom/baidu/nadcore/player/widget/BdPlayerProgressView;", "durationView", "Lcom/baidu/nadcore/player/widget/BdPlayerProgressView;", "", "isSeeking", "Z", "progressView", "Lcom/baidu/nadcore/player/callback/ISeekBarListener;", "seekBarListener", "Lcom/baidu/nadcore/player/callback/ISeekBarListener;", "getSeekBarListener", "()Lcom/baidu/nadcore/player/callback/ISeekBarListener;", "setSeekBarListener", "(Lcom/baidu/nadcore/player/callback/ISeekBarListener;)V", "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;", "seekBarView", "Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;", "getSeekBarView", "()Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;", "setSeekBarView", "(Lcom/baidu/nadcore/player/widget/BdThumbSeekBarView;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-widget_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public class BdPlayerSeekBar extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdThumbSeekBarView f37099e;

    /* renamed from: f  reason: collision with root package name */
    public BdPlayerProgressView f37100f;

    /* renamed from: g  reason: collision with root package name */
    public BdPlayerProgressView f37101g;

    /* renamed from: h  reason: collision with root package name */
    public f f37102h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap f37103i;
    @JvmField
    public boolean isSeeking;

    /* loaded from: classes10.dex */
    public static final class a implements BdThumbSeekBarView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdPlayerSeekBar a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(BdPlayerSeekBar bdPlayerSeekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdPlayerSeekBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdPlayerSeekBar;
        }

        @Override // com.baidu.nadcore.player.widget.BdThumbSeekBarView.b
        public void a(BdThumbSeekBarView bdThumbSeekBarView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdThumbSeekBarView) == null) {
                BdPlayerSeekBar bdPlayerSeekBar = this.a;
                bdPlayerSeekBar.isSeeking = true;
                f seekBarListener = bdPlayerSeekBar.getSeekBarListener();
                if (seekBarListener != null) {
                    seekBarListener.a(bdThumbSeekBarView);
                }
            }
        }

        @Override // com.baidu.nadcore.player.widget.BdThumbSeekBarView.b
        public void b(BdThumbSeekBarView bdThumbSeekBarView, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bdThumbSeekBarView, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.a.setPosition(i2);
                f seekBarListener = this.a.getSeekBarListener();
                if (seekBarListener != null) {
                    seekBarListener.b(bdThumbSeekBarView, i2, z);
                }
            }
        }

        @Override // com.baidu.nadcore.player.widget.BdThumbSeekBarView.b
        public void c(BdThumbSeekBarView bdThumbSeekBarView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdThumbSeekBarView) == null) {
                BdPlayerSeekBar bdPlayerSeekBar = this.a;
                bdPlayerSeekBar.isSeeking = false;
                f seekBarListener = bdPlayerSeekBar.getSeekBarListener();
                if (seekBarListener != null) {
                    seekBarListener.c(this.a.getSeekBarView());
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this.f37103i) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f37103i == null) {
                this.f37103i = new HashMap();
            }
            View view = (View) this.f37103i.get(Integer.valueOf(i2));
            if (view == null) {
                View findViewById = findViewById(i2);
                this.f37103i.put(Integer.valueOf(i2), findViewById);
                return findViewById;
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(n.nad_bdvideoplayer_seek_bar_view, this);
            this.f37100f = (BdPlayerProgressView) findViewById(m.nad_main_progress_text);
            this.f37101g = (BdPlayerProgressView) findViewById(m.nad_main_duration_text);
            BdThumbSeekBarView bdThumbSeekBarView = (BdThumbSeekBarView) findViewById(m.main_view_seekbar);
            this.f37099e = bdThumbSeekBarView;
            if (bdThumbSeekBarView != null) {
                bdThumbSeekBarView.setOnSeekBarChangeListener(new a(this));
            }
        }
    }

    public final f getSeekBarListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37102h : (f) invokeV.objValue;
    }

    public final BdThumbSeekBarView getSeekBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37099e : (BdThumbSeekBarView) invokeV.objValue;
    }

    public void setBufferingPosition(int i2) {
        BdThumbSeekBarView bdThumbSeekBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (bdThumbSeekBarView = this.f37099e) == null) {
            return;
        }
        bdThumbSeekBarView.setBufferingProgress(i2);
    }

    public void setDuration(int i2) {
        BdPlayerProgressView bdPlayerProgressView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            BdThumbSeekBarView bdThumbSeekBarView = this.f37099e;
            if (bdThumbSeekBarView != null) {
                bdThumbSeekBarView.setMax(i2);
            }
            if (this.f37101g != null) {
                String b2 = d.b(i2, false);
                if (b2 != null) {
                    if (!(!(b2.length() == 0))) {
                        b2 = null;
                    }
                    if (b2 == null || (bdPlayerProgressView = this.f37101g) == null) {
                        return;
                    }
                    bdPlayerProgressView.setPositionText(b2);
                }
            }
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            BdThumbSeekBarView bdThumbSeekBarView = this.f37099e;
            boolean z = false;
            if (bdThumbSeekBarView != null) {
                bdThumbSeekBarView.setProgress(i2);
                if (bdThumbSeekBarView.getMax() >= 3600) {
                    z = true;
                }
            }
            String b2 = d.b(i2, z);
            BdPlayerProgressView bdPlayerProgressView = this.f37100f;
            if (bdPlayerProgressView != null) {
                if (!(true ^ TextUtils.isEmpty(b2))) {
                    bdPlayerProgressView = null;
                }
                if (bdPlayerProgressView != null) {
                    bdPlayerProgressView.setPositionText(b2);
                }
            }
        }
    }

    public final void setSeekBarListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f37102h = fVar;
        }
    }

    public final void setSeekBarView(BdThumbSeekBarView bdThumbSeekBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdThumbSeekBarView) == null) {
            this.f37099e = bdThumbSeekBarView;
        }
    }

    public void switchToFull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BdPlayerProgressView bdPlayerProgressView = this.f37100f;
            if (bdPlayerProgressView != null) {
                bdPlayerProgressView.setTextSize(d.a(this, 12.0f));
            }
            BdPlayerProgressView bdPlayerProgressView2 = this.f37101g;
            if (bdPlayerProgressView2 != null) {
                bdPlayerProgressView2.setTextSize(d.a(this, 12.0f));
            }
            BdThumbSeekBarView bdThumbSeekBarView = this.f37099e;
            ViewGroup.LayoutParams layoutParams = bdThumbSeekBarView != null ? bdThumbSeekBarView.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = d.a(this, 3.0f);
                layoutParams2.rightMargin = d.a(this, 1.0f);
                BdThumbSeekBarView bdThumbSeekBarView2 = this.f37099e;
                if (bdThumbSeekBarView2 != null) {
                    bdThumbSeekBarView2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BdPlayerProgressView bdPlayerProgressView = this.f37100f;
            if (bdPlayerProgressView != null) {
                bdPlayerProgressView.setTextSize(d.a(this, 10.0f));
            }
            BdPlayerProgressView bdPlayerProgressView2 = this.f37101g;
            if (bdPlayerProgressView2 != null) {
                bdPlayerProgressView2.setTextSize(d.a(this, 10.0f));
            }
            BdThumbSeekBarView bdThumbSeekBarView = this.f37099e;
            ViewGroup.LayoutParams layoutParams = bdThumbSeekBarView != null ? bdThumbSeekBarView.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = d.a(this, 3.0f);
                layoutParams2.rightMargin = d.a(this, 3.0f);
                BdThumbSeekBarView bdThumbSeekBarView2 = this.f37099e;
                if (bdThumbSeekBarView2 != null) {
                    bdThumbSeekBarView2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void syncPos(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048588, this, i2, i3, i4) == null) || this.isSeeking) {
            return;
        }
        setPosition(i2);
        setDuration(i3);
        setBufferingPosition(i4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }
}
