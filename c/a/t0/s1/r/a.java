package c.a.t0.s1.r;

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
/* loaded from: classes8.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f22217b;

    /* renamed from: c  reason: collision with root package name */
    public View f22218c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f22219d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f22220e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f22221f;

    /* renamed from: g  reason: collision with root package name */
    public View f22222g;

    /* renamed from: h  reason: collision with root package name */
    public View f22223h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f22224i;

    /* renamed from: c.a.t0.s1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1375a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22225e;

        public C1375a(a aVar) {
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
            this.f22225e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f22225e.f22222g.setTag(editable.toString().trim());
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
                if (this.f22225e.f22219d.length() > 0) {
                    this.f22225e.f22220e.setVisibility(0);
                } else {
                    this.f22225e.f22220e.setVisibility(8);
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
        this.a = null;
        this.f22217b = null;
        this.f22218c = null;
        this.f22219d = null;
        this.f22220e = null;
        this.f22221f = null;
        this.f22222g = null;
        this.f22224i = null;
        this.f22224i = addGroupActivity;
        initUI();
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f22224i.getLayoutMode().k(i2 == 1);
            this.f22224i.getLayoutMode().j(this.a);
            this.f22217b.onChangeSkinType(this.f22224i.getPageContext(), i2);
        }
    }

    public void g() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f22219d) == null) {
            return;
        }
        editText.setText("");
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22218c : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22220e : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f22224i.setContentView(R.layout.im_add_group_activity);
            this.a = this.f22224i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f22224i.findViewById(R.id.addgroup_navigationbar);
            this.f22217b = navigationBar;
            this.f22218c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f22217b.setTitleText(this.f22224i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f22224i.findViewById(R.id.addgroup_input);
            this.f22219d = editText;
            editText.setInputType(2);
            this.f22220e = (ImageButton) this.f22224i.findViewById(R.id.addgroup_delbtn);
            this.f22222g = this.f22224i.findViewById(R.id.addgroup_searchbutton);
            this.f22223h = this.f22224i.findViewById(R.id.addgroup_vcode);
            this.f22219d.addTextChangedListener(new C1375a(this));
            this.f22222g = this.f22224i.findViewById(R.id.addgroup_searchbutton);
            this.f22221f = (ProgressBar) this.f22224i.findViewById(R.id.addgroup_progress);
            this.f22218c.setOnClickListener(this.f22224i);
            this.f22220e.setOnClickListener(this.f22224i);
            this.f22222g.setOnClickListener(this.f22224i);
            this.f22223h.setOnClickListener(this.f22224i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f22223h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22222g : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22223h : (View) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f22221f.setVisibility(z ? 0 : 8);
        }
    }
}
