package c.a.p0.u1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import c.a.d.a.d;
import c.a.d.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18887b;

    /* renamed from: c  reason: collision with root package name */
    public View f18888c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f18889d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f18890e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f18891f;

    /* renamed from: g  reason: collision with root package name */
    public View f18892g;

    /* renamed from: h  reason: collision with root package name */
    public View f18893h;
    public AddGroupActivity i;

    /* renamed from: c.a.p0.u1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1423a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1423a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.f18892g.setTag(editable.toString().trim());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (this.a.f18889d.length() > 0) {
                    this.a.f18890e.setVisibility(0);
                } else {
                    this.a.f18890e.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {addGroupActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f18887b = null;
        this.f18888c = null;
        this.f18889d = null;
        this.f18890e = null;
        this.f18891f = null;
        this.f18892g = null;
        this.i = null;
        this.i = addGroupActivity;
        n();
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i.getLayoutMode().k(i == 1);
            this.i.getLayoutMode().j(this.a);
            this.f18887b.onChangeSkinType(this.i.getPageContext(), i);
        }
    }

    public void i() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f18889d) == null) {
            return;
        }
        editText.setText("");
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18888c : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18890e : (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18892g : (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18893h : (View) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i.setContentView(R.layout.obfuscated_res_0x7f0d03c9);
            this.a = this.i.findViewById(R.id.obfuscated_res_0x7f090121);
            NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.obfuscated_res_0x7f09011f);
            this.f18887b = navigationBar;
            this.f18888c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18887b.setTitleText(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f00c5));
            EditText editText = (EditText) this.i.findViewById(R.id.obfuscated_res_0x7f09011e);
            this.f18889d = editText;
            editText.setInputType(2);
            this.f18890e = (ImageButton) this.i.findViewById(R.id.obfuscated_res_0x7f09011d);
            this.f18892g = this.i.findViewById(R.id.obfuscated_res_0x7f090122);
            this.f18893h = this.i.findViewById(R.id.obfuscated_res_0x7f090123);
            this.f18889d.addTextChangedListener(new C1423a(this));
            this.f18892g = this.i.findViewById(R.id.obfuscated_res_0x7f090122);
            this.f18891f = (ProgressBar) this.i.findViewById(R.id.obfuscated_res_0x7f090120);
            this.f18888c.setOnClickListener(this.i);
            this.f18890e.setOnClickListener(this.i);
            this.f18892g.setOnClickListener(this.i);
            this.f18893h.setOnClickListener(this.i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f18893h.setVisibility(8);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f18891f.setVisibility(z ? 0 : 8);
        }
    }
}
