package c.a.u0.q4;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Spannable f21521e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.f1.n.f f21522f;

    /* renamed from: g  reason: collision with root package name */
    public int f21523g;

    public h(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spannable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21522f = null;
        this.f21523g = 0;
        this.f21521e = spannable;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f21523g = i2;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        c.a.t0.f1.n.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (action == 3 && (fVar = this.f21522f) != null) {
                    fVar.g(TbadkCoreApplication.getInst().getResources().getColor(c.a.u0.a4.d.transparent));
                    view.invalidate();
                    this.f21522f = null;
                    return false;
                }
                if (action == 1 || action == 0) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    Layout layout = textView.getLayout();
                    if (layout == null) {
                        return false;
                    }
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), (x - textView.getTotalPaddingLeft()) + textView.getScrollX());
                    Spannable spannable = this.f21521e;
                    if (spannable == null) {
                        return false;
                    }
                    c.a.t0.f1.n.f[] fVarArr = (c.a.t0.f1.n.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, c.a.t0.f1.n.f.class);
                    if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                        if (action == 1) {
                            fVarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(c.a.u0.a4.d.transparent));
                            fVarArr[0].onClick(textView);
                            view.invalidate();
                        } else {
                            c.a.t0.f1.n.f fVar2 = fVarArr[0];
                            this.f21522f = fVar2;
                            if (fVar2.e()) {
                                int i2 = this.f21523g;
                                if (i2 != 0) {
                                    fVarArr[0].g(SkinManager.getColor(i2));
                                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    fVarArr[0].g(SkinManager.getColor(c.a.u0.a4.d.CAM_X0204));
                                } else {
                                    fVarArr[0].g(SkinManager.getColor(c.a.u0.a4.d.cp_bg_line_z));
                                }
                            }
                            Spannable spannable2 = this.f21521e;
                            Selection.setSelection(spannable2, spannable2.getSpanStart(fVarArr[0]), this.f21521e.getSpanEnd(fVarArr[0]));
                            view.invalidate();
                        }
                        return true;
                    }
                    c.a.t0.f1.n.f fVar3 = this.f21522f;
                    if (fVar3 != null) {
                        fVar3.g(TbadkCoreApplication.getInst().getResources().getColor(c.a.u0.a4.d.transparent));
                        view.invalidate();
                    }
                    Selection.removeSelection(this.f21521e);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
