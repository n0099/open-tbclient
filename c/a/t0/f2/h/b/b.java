package c.a.t0.f2.h.b;

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
import c.a.s0.x.m;
import c.a.t0.f2.h.b.c.d;
import c.a.t0.f2.h.f.c;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18109b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18110c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18111d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f18112e;

    /* renamed from: f  reason: collision with root package name */
    public Window f18113f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f18114g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f18115h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f18116i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f18117j;

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
        this.f18112e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f18113f = window;
        this.f18111d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.a = (EditText) this.f18113f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f18113f.findViewById(R.id.tail_edit_submit);
        this.f18109b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f18113f.findViewById(R.id.tail_edit_cancel);
        this.f18114g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f18110c = (TextView) this.f18113f.findViewById(R.id.tail_edit_text_number);
        this.f18116i = (FrameLayout) this.f18113f.findViewById(R.id.tail_edit_editor);
        this.f18117j = (ProgressBar) this.f18113f.findViewById(R.id.tail_edit_progress);
    }

    public void a(c.a.s0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            this.f18115h = new EditorTools(this.f18112e.getPageContext().getPageActivity());
            d();
            c(bVar);
            b(bVar, str);
            this.f18115h.build();
            this.f18115h.sendAction(new c.a.s0.x.a(35, 5, Boolean.FALSE));
            this.f18115h.display();
            o(this.f18115h);
        }
    }

    public final void b(c.a.s0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) {
            this.f18115h.addTool(new d(this.f18112e.getPageContext(), 2, str));
            this.f18115h.setActionListener(26, bVar);
            this.f18115h.setActionListener(3, bVar);
        }
    }

    public final void c(c.a.s0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.f18115h.collect(arrayList);
            m findToolById = this.f18115h.findToolById(5);
            if (findToolById != null) {
                findToolById.f14537j = 1;
                findToolById.e(false);
            }
            this.f18115h.setActionListener(24, bVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f18115h.setBarMaxLauCount(4);
            this.f18115h.setBarLauncherType(1);
            this.f18115h.showLinePositionBottom(true);
            this.f18115h.setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.a.getText().toString().substring(0, this.a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.a.getText().delete(this.a.getSelectionStart() - i2, this.a.getSelectionStart());
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18112e.ShowSoftKeyPadDelay(this.a);
            EditText editText = this.a;
            editText.setSelection(editText.length());
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getText().toString() : (String) invokeV.objValue;
    }

    public EditText h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (EditText) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f18117j.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f18115h.hideTools();
            this.f18115h.sendAction(new c.a.s0.x.a(5, -1, null));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = this.a;
            editText.setSelection(editText.length());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f18112e.getLayoutMode().k(i2 == 1);
            this.f18112e.getLayoutMode().j(this.f18111d);
            this.f18115h.onChangeSkinType(i2);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.a.setTextColor(c.a(str));
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a.setText(TbFaceManager.e().l(this.f18112e.getPageContext().getPageActivity(), str, null));
        }
    }

    public void o(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f18116i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f18109b.setEnabled(z);
        }
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            TextView textView = this.f18110c;
            textView.setText(i2 + "/" + i3);
            int i4 = R.color.CAM_X0109;
            if (i2 == i3) {
                i4 = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(this.f18110c, i4, 1);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f18117j.setVisibility(0);
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
