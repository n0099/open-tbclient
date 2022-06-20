package com.baidu.searchbox.player.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.callback.ISeekBarListener;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tieba.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0005¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00060"}, d2 = {"Lcom/baidu/searchbox/player/widget/BdPlayerSeekBar;", "Landroid/widget/FrameLayout;", "", "inflate", "()V", "", "bufferingPos", "setBufferingPosition", "(I)V", "duration", "setDuration", "position", "setPosition", "switchToFull", "switchToHalf", "pos", "dur", "buffer", "syncPos", "(III)V", "Lcom/baidu/searchbox/player/widget/BdPlayerProgressView;", "durationView", "Lcom/baidu/searchbox/player/widget/BdPlayerProgressView;", "", "isSeeking", "Z", "progressView", "Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "seekBarListener", "Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "getSeekBarListener", "()Lcom/baidu/searchbox/player/callback/ISeekBarListener;", "setSeekBarListener", "(Lcom/baidu/searchbox/player/callback/ISeekBarListener;)V", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "seekBarView", "Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "getSeekBarView", "()Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;", "setSeekBarView", "(Lcom/baidu/searchbox/player/widget/BdThumbSeekBarView;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BdPlayerSeekBar extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;
    public BdPlayerProgressView durationView;
    @JvmField
    public boolean isSeeking;
    public BdPlayerProgressView progressView;
    public ISeekBarListener seekBarListener;
    public BdThumbSeekBarView seekBarView;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public /* synthetic */ BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void inflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0150, this);
            this.progressView = (BdPlayerProgressView) findViewById(R.id.obfuscated_res_0x7f091338);
            this.durationView = (BdPlayerProgressView) findViewById(R.id.obfuscated_res_0x7f091334);
            BdThumbSeekBarView bdThumbSeekBarView = (BdThumbSeekBarView) findViewById(R.id.obfuscated_res_0x7f091344);
            this.seekBarView = bdThumbSeekBarView;
            if (bdThumbSeekBarView != null) {
                bdThumbSeekBarView.setOnSeekBarChangeListener(new BdThumbSeekBarView.OnBdSeekBarChangeListener(this) { // from class: com.baidu.searchbox.player.widget.BdPlayerSeekBar$inflate$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdPlayerSeekBar this$0;

                    /* JADX DEBUG: Incorrect args count in method signature: ()V */
                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.searchbox.player.widget.BdThumbSeekBarView.OnBdSeekBarChangeListener
                    public void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView2, int i, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{bdThumbSeekBarView2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                            this.this$0.setPosition(i);
                            ISeekBarListener seekBarListener = this.this$0.getSeekBarListener();
                            if (seekBarListener != null) {
                                seekBarListener.onProgressChanged(bdThumbSeekBarView2, i, z);
                            }
                        }
                    }

                    @Override // com.baidu.searchbox.player.widget.BdThumbSeekBarView.OnBdSeekBarChangeListener
                    public void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdThumbSeekBarView2) == null) {
                            BdPlayerSeekBar bdPlayerSeekBar = this.this$0;
                            bdPlayerSeekBar.isSeeking = true;
                            ISeekBarListener seekBarListener = bdPlayerSeekBar.getSeekBarListener();
                            if (seekBarListener != null) {
                                seekBarListener.onStartTrackingTouch(bdThumbSeekBarView2);
                            }
                        }
                    }

                    @Override // com.baidu.searchbox.player.widget.BdThumbSeekBarView.OnBdSeekBarChangeListener
                    public void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdThumbSeekBarView2) == null) {
                            BdPlayerSeekBar bdPlayerSeekBar = this.this$0;
                            bdPlayerSeekBar.isSeeking = false;
                            ISeekBarListener seekBarListener = bdPlayerSeekBar.getSeekBarListener();
                            if (seekBarListener != null) {
                                seekBarListener.onStopTrackingTouch(this.this$0.getSeekBarView());
                            }
                        }
                    }
                });
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this._$_findViewCache) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                this._$_findViewCache.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final ISeekBarListener getSeekBarListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.seekBarListener : (ISeekBarListener) invokeV.objValue;
    }

    public final BdThumbSeekBarView getSeekBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.seekBarView : (BdThumbSeekBarView) invokeV.objValue;
    }

    public void setBufferingPosition(int i) {
        BdThumbSeekBarView bdThumbSeekBarView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (bdThumbSeekBarView = this.seekBarView) == null) {
            return;
        }
        bdThumbSeekBarView.setBufferingProgress(i);
    }

    public void setDuration(int i) {
        BdPlayerProgressView bdPlayerProgressView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
            if (bdThumbSeekBarView != null) {
                bdThumbSeekBarView.setMax(i);
            }
            if (this.durationView != null) {
                String textWithSecond = BdPlayerUtils.getTextWithSecond(i, false);
                if (textWithSecond != null) {
                    if (!(!(textWithSecond.length() == 0))) {
                        textWithSecond = null;
                    }
                    if (textWithSecond == null || (bdPlayerProgressView = this.durationView) == null) {
                        return;
                    }
                    bdPlayerProgressView.setPositionText(textWithSecond);
                }
            }
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
            boolean z = false;
            if (bdThumbSeekBarView != null) {
                bdThumbSeekBarView.setProgress(i);
                if (bdThumbSeekBarView.getMax() >= 3600) {
                    z = true;
                }
            }
            String textWithSecond = BdPlayerUtils.getTextWithSecond(i, z);
            BdPlayerProgressView bdPlayerProgressView = this.progressView;
            if (bdPlayerProgressView != null) {
                if (!(true ^ TextUtils.isEmpty(textWithSecond))) {
                    bdPlayerProgressView = null;
                }
                if (bdPlayerProgressView != null) {
                    bdPlayerProgressView.setPositionText(textWithSecond);
                }
            }
        }
    }

    public final void setSeekBarListener(ISeekBarListener iSeekBarListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iSeekBarListener) == null) {
            this.seekBarListener = iSeekBarListener;
        }
    }

    public final void setSeekBarView(BdThumbSeekBarView bdThumbSeekBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdThumbSeekBarView) == null) {
            this.seekBarView = bdThumbSeekBarView;
        }
    }

    public void switchToFull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BdPlayerProgressView bdPlayerProgressView = this.progressView;
            if (bdPlayerProgressView != null) {
                bdPlayerProgressView.setTextSize(BdPlayerUtils.dp2px(this, 12.0f));
            }
            BdPlayerProgressView bdPlayerProgressView2 = this.durationView;
            if (bdPlayerProgressView2 != null) {
                bdPlayerProgressView2.setTextSize(BdPlayerUtils.dp2px(this, 12.0f));
            }
            BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
            ViewGroup.LayoutParams layoutParams = bdThumbSeekBarView != null ? bdThumbSeekBarView.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = BdPlayerUtils.dp2px(this, 3.0f);
                layoutParams2.rightMargin = BdPlayerUtils.dp2px(this, 1.0f);
                BdThumbSeekBarView bdThumbSeekBarView2 = this.seekBarView;
                if (bdThumbSeekBarView2 != null) {
                    bdThumbSeekBarView2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BdPlayerProgressView bdPlayerProgressView = this.progressView;
            if (bdPlayerProgressView != null) {
                bdPlayerProgressView.setTextSize(BdPlayerUtils.dp2px(this, 10.0f));
            }
            BdPlayerProgressView bdPlayerProgressView2 = this.durationView;
            if (bdPlayerProgressView2 != null) {
                bdPlayerProgressView2.setTextSize(BdPlayerUtils.dp2px(this, 10.0f));
            }
            BdThumbSeekBarView bdThumbSeekBarView = this.seekBarView;
            ViewGroup.LayoutParams layoutParams = bdThumbSeekBarView != null ? bdThumbSeekBarView.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = BdPlayerUtils.dp2px(this, 3.0f);
                layoutParams2.rightMargin = BdPlayerUtils.dp2px(this, 3.0f);
                BdThumbSeekBarView bdThumbSeekBarView2 = this.seekBarView;
                if (bdThumbSeekBarView2 != null) {
                    bdThumbSeekBarView2.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void syncPos(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) || this.isSeeking) {
            return;
        }
        setPosition(i);
        setDuration(i2);
        setBufferingPosition(i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BdPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        inflate();
    }
}
