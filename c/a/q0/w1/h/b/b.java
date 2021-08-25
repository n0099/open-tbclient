package c.a.q0.w1.h.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.x.m;
import c.a.q0.w1.h.b.c.d;
import c.a.q0.w1.h.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public EditText f28067a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28068b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28069c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f28070d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f28071e;

    /* renamed from: f  reason: collision with root package name */
    public Window f28072f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f28073g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f28074h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f28075i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f28076j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener, onClickListener2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28071e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f28072f = window;
        this.f28070d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f28067a = (EditText) this.f28072f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f28072f.findViewById(R.id.tail_edit_submit);
        this.f28068b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f28072f.findViewById(R.id.tail_edit_cancel);
        this.f28073g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f28069c = (TextView) this.f28072f.findViewById(R.id.tail_edit_text_number);
        this.f28075i = (FrameLayout) this.f28072f.findViewById(R.id.tail_edit_editor);
        this.f28076j = (ProgressBar) this.f28072f.findViewById(R.id.tail_edit_progress);
    }

    public void a(c.a.p0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            this.f28074h = new EditorTools(this.f28071e.getPageContext().getPageActivity());
            d();
            c(bVar);
            b(bVar, str);
            this.f28074h.build();
            this.f28074h.sendAction(new c.a.p0.x.a(35, 5, Boolean.FALSE));
            this.f28074h.display();
            o(this.f28074h);
        }
    }

    public final void b(c.a.p0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) {
            this.f28074h.addTool(new d(this.f28071e.getPageContext(), 2, str));
            this.f28074h.setActionListener(26, bVar);
            this.f28074h.setActionListener(3, bVar);
        }
    }

    public final void c(c.a.p0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.f28074h.collect(arrayList);
            m findToolById = this.f28074h.findToolById(5);
            if (findToolById != null) {
                findToolById.f15101j = 1;
                findToolById.f(false);
            }
            this.f28074h.setActionListener(24, bVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f28074h.setBarMaxLauCount(4);
            this.f28074h.setBarLauncherType(1);
            this.f28074h.showLinePositionBottom(true);
            this.f28074h.setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f28067a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f28067a.getText().toString().substring(0, this.f28067a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f28067a.getText().delete(this.f28067a.getSelectionStart() - i2, this.f28067a.getSelectionStart());
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28071e.ShowSoftKeyPadDelay(this.f28067a);
            EditText editText = this.f28067a;
            editText.setSelection(editText.length());
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28067a.getText().toString() : (String) invokeV.objValue;
    }

    public EditText h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28067a : (EditText) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f28076j.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f28074h.hideTools();
            this.f28074h.sendAction(new c.a.p0.x.a(5, -1, null));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = this.f28067a;
            editText.setSelection(editText.length());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f28071e.getLayoutMode().k(i2 == 1);
            this.f28071e.getLayoutMode().j(this.f28070d);
            this.f28074h.onChangeSkinType(i2);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f28067a.setTextColor(c.a(str));
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f28067a.setText(TbFaceManager.e().l(this.f28071e.getPageContext().getPageActivity(), str, null));
        }
    }

    public void o(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f28075i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f28068b.setEnabled(z);
        }
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            TextView textView = this.f28069c;
            textView.setText(i2 + "/" + i3);
            int i4 = R.color.CAM_X0109;
            if (i2 == i3) {
                i4 = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(this.f28069c, i4, 1);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f28076j.setVisibility(0);
        }
    }

    public void s(TailData tailData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, tailData) == null) || tailData == null) {
            return;
        }
        n(tailData.getContent());
        m(tailData.getFontColor());
    }
}
