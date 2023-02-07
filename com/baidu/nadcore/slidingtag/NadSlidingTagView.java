package com.baidu.nadcore.slidingtag;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b21;
import com.baidu.tieba.b51;
import com.baidu.tieba.c21;
import com.baidu.tieba.f21;
import com.baidu.tieba.lr0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002%&B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J!\u0010\u001a\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadSlidingTagView;", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagBaseView;", "", "getCurrentMeasuredWidth", "()I", "getNextMeasuredWidth", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "", DelayTB.DELAY, "", "innerStartDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;)V", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagView$IOnActionListener;", "(Lcom/baidu/nadcore/slidingtag/NadSlidingTagView$IOnActionListener;)V", "setLinear", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "maxWidthPx", "setMaxWidth", "(I)V", "setTextViewList", "start", "startDelay", "Lcom/baidu/nadcore/slidingtag/NadSlidingTagView$IOnActionListener;", "maxWidth", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IOnActionListener", "SimpleActionListener", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadSlidingTagView extends NadSlidingTagBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a p;
    public int q;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Context context, String str, int i, String str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadSlidingTagView(Context context) {
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
    public NadSlidingTagView(Context context, AttributeSet attributeSet) {
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

    /* loaded from: classes2.dex */
    public static final class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c21 a;

        public b(c21 c21Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c21Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c21Var;
        }

        @Override // com.baidu.nadcore.slidingtag.NadSlidingTagView.a
        public void a(Context context, String text, int i, String cmd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, context, text, i, cmd) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(cmd, "cmd");
                c21 c21Var = this.a;
                if (c21Var != null) {
                    c21Var.a(new b21(context, text, i, cmd));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ NadSlidingTagView b;
        public final /* synthetic */ lr0 c;

        public c(LinearLayout linearLayout, NadSlidingTagView nadSlidingTagView, lr0 lr0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout, nadSlidingTagView, lr0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linearLayout;
            this.b = nadSlidingTagView;
            this.c = lr0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            a aVar;
            CharSequence text;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.b.p) != null) {
                Context context = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.b.getTvList(), this.b.getCurrentIdx());
                aVar.a(context, (textView == null || (text = textView.getText()) == null || (r1 = text.toString()) == null) ? "" : "", this.b.getCurrentIdx(), this.c.g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadSlidingTagView(Context context, AttributeSet attributeSet, int i) {
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
        LayoutInflater.from(context).inflate(R.layout.nad_sliding_tag_layout, (ViewGroup) this, true);
    }

    public /* synthetic */ NadSlidingTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setLinear(lr0 lr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, lr0Var) == null) {
            LinearLayout linear = getLinear();
            int i = 0;
            if (!getTvList().isEmpty()) {
                if (getLinear().getChildAt(0) instanceof AdImageView) {
                    linear.setPadding(b51.c.a(linear.getContext(), 5.0f), b51.c.a(linear.getContext(), 5.0f), b51.c.a(linear.getContext(), 7.0f), b51.c.a(linear.getContext(), 5.0f));
                } else {
                    linear.setPadding(b51.c.a(linear.getContext(), 7.0f), b51.c.a(linear.getContext(), 8.0f), b51.c.a(linear.getContext(), 7.0f), b51.c.a(linear.getContext(), 8.0f));
                }
                linear.setGravity(16);
                TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), 0);
                if (textView != null) {
                    s(textView);
                    linear.addView(textView, r());
                    setTextHeight(o(textView));
                    Unit unit = Unit.INSTANCE;
                }
                linear.setOnClickListener(new c(linear, this, lr0Var));
            } else {
                i = 8;
            }
            linear.setVisibility(i);
        }
    }

    private final void setTextViewList(lr0 lr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, lr0Var) == null) {
            for (lr0.c cVar : lr0Var.a) {
                TextView a2 = f21.a(getContext(), cVar);
                if (a2 != null) {
                    a2.setTextSize(0, getTextSizePx());
                    a2.setLayoutParams(r());
                    a2.setPadding(0, 0, 0, 0);
                    a2.setMaxLines(1);
                    a2.setSingleLine();
                    a2.setEllipsize(TextUtils.TruncateAt.END);
                    a2.setGravity(16);
                    a2.setIncludeFontPadding(false);
                    a2.setVisibility(0);
                    if (a2 != null) {
                        getTvList().add(a2);
                    }
                }
            }
        }
    }

    public final void setActionListener(a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.p = listener;
        }
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setMaxWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.q = i;
        }
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getCurrentMeasuredWidth() {
        InterceptResult invokeV;
        int a2;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), getCurrentIdx());
            if (textView == null) {
                setVisibility(8);
                return 0;
            }
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(r());
            }
            if (getLinear().getChildAt(0) instanceof AdImageView) {
                a2 = b51.c.a(getContext(), 5.0f) + getIconSizePx() + b51.c.a(getContext(), 5.0f) + p(textView);
                a3 = b51.c.a(getContext(), 7.0f);
            } else {
                a2 = b51.c.a(getContext(), 7.0f) + p(textView);
                a3 = b51.c.a(getContext(), 7.0f);
            }
            int i = a2 + a3;
            int i2 = this.q;
            if (i2 > 0) {
                i = RangesKt___RangesKt.coerceAtMost(i, i2);
            }
            getWidthMap().put(Integer.valueOf(getCurrentIdx()), Integer.valueOf(i));
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public int getNextMeasuredWidth() {
        InterceptResult invokeV;
        int a2;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int nextIndex = getNextIndex();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(getTvList(), nextIndex);
            if (textView == null) {
                setVisibility(8);
                return 0;
            }
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(r());
            }
            if (getLinear().getChildAt(0) instanceof AdImageView) {
                a2 = b51.c.a(getContext(), 5.0f) + getIconSizePx() + b51.c.a(getContext(), 5.0f) + p(textView);
                a3 = b51.c.a(getContext(), 7.0f);
            } else {
                a2 = b51.c.a(getContext(), 7.0f) + p(textView);
                a3 = b51.c.a(getContext(), 7.0f);
            }
            int i = a2 + a3;
            int i2 = this.q;
            if (i2 > 0) {
                i = RangesKt___RangesKt.coerceAtMost(i, i2);
            }
            getWidthMap().put(Integer.valueOf(nextIndex), Integer.valueOf(i));
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.slidingtag.NadSlidingTagBaseView
    public void setActionListener(c21 c21Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c21Var) == null) {
            setActionListener(new b(c21Var));
        }
    }
}
