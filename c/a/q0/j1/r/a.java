package c.a.q0.j1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import c.a.e.a.d;
import c.a.e.a.f;
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
/* loaded from: classes3.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20990a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f20991b;

    /* renamed from: c  reason: collision with root package name */
    public View f20992c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f20993d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f20994e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f20995f;

    /* renamed from: g  reason: collision with root package name */
    public View f20996g;

    /* renamed from: h  reason: collision with root package name */
    public View f20997h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f20998i;

    /* renamed from: c.a.q0.j1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0976a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20999e;

        public C0976a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20999e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f20999e.f20996g.setTag(editable.toString().trim());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                if (this.f20999e.f20993d.length() > 0) {
                    this.f20999e.f20994e.setVisibility(0);
                } else {
                    this.f20999e.f20994e.setVisibility(8);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20990a = null;
        this.f20991b = null;
        this.f20992c = null;
        this.f20993d = null;
        this.f20994e = null;
        this.f20995f = null;
        this.f20996g = null;
        this.f20998i = null;
        this.f20998i = addGroupActivity;
        initUI();
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f20998i.getLayoutMode().k(i2 == 1);
            this.f20998i.getLayoutMode().j(this.f20990a);
            this.f20991b.onChangeSkinType(this.f20998i.getPageContext(), i2);
        }
    }

    public void g() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f20993d) == null) {
            return;
        }
        editText.setText("");
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20992c : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20994e : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20998i.setContentView(R.layout.im_add_group_activity);
            this.f20990a = this.f20998i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f20998i.findViewById(R.id.addgroup_navigationbar);
            this.f20991b = navigationBar;
            this.f20992c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20991b.setTitleText(this.f20998i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f20998i.findViewById(R.id.addgroup_input);
            this.f20993d = editText;
            editText.setInputType(2);
            this.f20994e = (ImageButton) this.f20998i.findViewById(R.id.addgroup_delbtn);
            this.f20996g = this.f20998i.findViewById(R.id.addgroup_searchbutton);
            this.f20997h = this.f20998i.findViewById(R.id.addgroup_vcode);
            this.f20993d.addTextChangedListener(new C0976a(this));
            this.f20996g = this.f20998i.findViewById(R.id.addgroup_searchbutton);
            this.f20995f = (ProgressBar) this.f20998i.findViewById(R.id.addgroup_progress);
            this.f20992c.setOnClickListener(this.f20998i);
            this.f20994e.setOnClickListener(this.f20998i);
            this.f20996g.setOnClickListener(this.f20998i);
            this.f20997h.setOnClickListener(this.f20998i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f20997h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20996g : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20997h : (View) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f20995f.setVisibility(z ? 0 : 8);
        }
    }
}
