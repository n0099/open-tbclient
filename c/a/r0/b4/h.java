package c.a.r0.b4;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Spannable f16219e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.f1.m.e f16220f;

    /* renamed from: g  reason: collision with root package name */
    public int f16221g;

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
        this.f16220f = null;
        this.f16221g = 0;
        this.f16219e = spannable;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f16221g = i2;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        c.a.q0.f1.m.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (action == 3 && (eVar = this.f16220f) != null) {
                    eVar.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                    this.f16220f = null;
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
                    Spannable spannable = this.f16219e;
                    if (spannable == null) {
                        return false;
                    }
                    c.a.q0.f1.m.e[] eVarArr = (c.a.q0.f1.m.e[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, c.a.q0.f1.m.e.class);
                    if (eVarArr != null && eVarArr.length != 0 && eVarArr[0] != null) {
                        if (action == 1) {
                            eVarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                            eVarArr[0].onClick(textView);
                            view.invalidate();
                        } else {
                            c.a.q0.f1.m.e eVar2 = eVarArr[0];
                            this.f16220f = eVar2;
                            if (eVar2.e()) {
                                int i2 = this.f16221g;
                                if (i2 != 0) {
                                    eVarArr[0].g(SkinManager.getColor(i2));
                                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    eVarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                                } else {
                                    eVarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                                }
                            }
                            Spannable spannable2 = this.f16219e;
                            Selection.setSelection(spannable2, spannable2.getSpanStart(eVarArr[0]), this.f16219e.getSpanEnd(eVarArr[0]));
                            view.invalidate();
                        }
                        return true;
                    }
                    c.a.q0.f1.m.e eVar3 = this.f16220f;
                    if (eVar3 != null) {
                        eVar3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        view.invalidate();
                    }
                    Selection.removeSelection(this.f16219e);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
