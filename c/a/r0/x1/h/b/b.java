package c.a.r0.x1.h.b;

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
import c.a.q0.x.m;
import c.a.r0.x1.h.b.c.d;
import c.a.r0.x1.h.f.c;
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
    public EditText f28774a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f28775b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28776c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f28777d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f28778e;

    /* renamed from: f  reason: collision with root package name */
    public Window f28779f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f28780g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f28781h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f28782i;

    /* renamed from: j  reason: collision with root package name */
    public ProgressBar f28783j;

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
        this.f28778e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f28779f = window;
        this.f28777d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f28774a = (EditText) this.f28779f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f28779f.findViewById(R.id.tail_edit_submit);
        this.f28775b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f28779f.findViewById(R.id.tail_edit_cancel);
        this.f28780g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f28776c = (TextView) this.f28779f.findViewById(R.id.tail_edit_text_number);
        this.f28782i = (FrameLayout) this.f28779f.findViewById(R.id.tail_edit_editor);
        this.f28783j = (ProgressBar) this.f28779f.findViewById(R.id.tail_edit_progress);
    }

    public void a(c.a.q0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, str) == null) {
            this.f28781h = new EditorTools(this.f28778e.getPageContext().getPageActivity());
            d();
            c(bVar);
            b(bVar, str);
            this.f28781h.build();
            this.f28781h.sendAction(new c.a.q0.x.a(35, 5, Boolean.FALSE));
            this.f28781h.display();
            o(this.f28781h);
        }
    }

    public final void b(c.a.q0.x.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str) == null) {
            this.f28781h.addTool(new d(this.f28778e.getPageContext(), 2, str));
            this.f28781h.setActionListener(26, bVar);
            this.f28781h.setActionListener(3, bVar);
        }
    }

    public final void c(c.a.q0.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.f28781h.collect(arrayList);
            m findToolById = this.f28781h.findToolById(5);
            if (findToolById != null) {
                findToolById.f15101j = 1;
                findToolById.f(false);
            }
            this.f28781h.setActionListener(24, bVar);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f28781h.setBarMaxLauCount(4);
            this.f28781h.setBarLauncherType(1);
            this.f28781h.showLinePositionBottom(true);
            this.f28781h.setBackgroundColorId(R.color.CAM_X0201);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f28774a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f28774a.getText().toString().substring(0, this.f28774a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f28774a.getText().delete(this.f28774a.getSelectionStart() - i2, this.f28774a.getSelectionStart());
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28778e.ShowSoftKeyPadDelay(this.f28774a);
            EditText editText = this.f28774a;
            editText.setSelection(editText.length());
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28774a.getText().toString() : (String) invokeV.objValue;
    }

    public EditText h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28774a : (EditText) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f28783j.setVisibility(8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f28781h.hideTools();
            this.f28781h.sendAction(new c.a.q0.x.a(5, -1, null));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = this.f28774a;
            editText.setSelection(editText.length());
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f28778e.getLayoutMode().k(i2 == 1);
            this.f28778e.getLayoutMode().j(this.f28777d);
            this.f28781h.onChangeSkinType(i2);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f28774a.setTextColor(c.a(str));
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f28774a.setText(TbFaceManager.e().l(this.f28778e.getPageContext().getPageActivity(), str, null));
        }
    }

    public void o(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f28782i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f28775b.setEnabled(z);
        }
    }

    public void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            TextView textView = this.f28776c;
            textView.setText(i2 + "/" + i3);
            int i4 = R.color.CAM_X0109;
            if (i2 == i3) {
                i4 = R.color.CAM_X0301;
            }
            SkinManager.setViewTextColor(this.f28776c, i4, 1);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f28783j.setVisibility(0);
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
