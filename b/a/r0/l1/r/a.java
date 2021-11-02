package b.a.r0.l1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import b.a.e.a.d;
import b.a.e.a.f;
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
/* loaded from: classes5.dex */
public class a extends d<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20335a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f20336b;

    /* renamed from: c  reason: collision with root package name */
    public View f20337c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f20338d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f20339e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f20340f;

    /* renamed from: g  reason: collision with root package name */
    public View f20341g;

    /* renamed from: h  reason: collision with root package name */
    public View f20342h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f20343i;

    /* renamed from: b.a.r0.l1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1010a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20344e;

        public C1010a(a aVar) {
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
            this.f20344e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f20344e.f20341g.setTag(editable.toString().trim());
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
                if (this.f20344e.f20338d.length() > 0) {
                    this.f20344e.f20339e.setVisibility(0);
                } else {
                    this.f20344e.f20339e.setVisibility(8);
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
        this.f20335a = null;
        this.f20336b = null;
        this.f20337c = null;
        this.f20338d = null;
        this.f20339e = null;
        this.f20340f = null;
        this.f20341g = null;
        this.f20343i = null;
        this.f20343i = addGroupActivity;
        initUI();
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f20343i.getLayoutMode().k(i2 == 1);
            this.f20343i.getLayoutMode().j(this.f20335a);
            this.f20336b.onChangeSkinType(this.f20343i.getPageContext(), i2);
        }
    }

    public void g() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f20338d) == null) {
            return;
        }
        editText.setText("");
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20337c : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20339e : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20343i.setContentView(R.layout.im_add_group_activity);
            this.f20335a = this.f20343i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f20343i.findViewById(R.id.addgroup_navigationbar);
            this.f20336b = navigationBar;
            this.f20337c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20336b.setTitleText(this.f20343i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f20343i.findViewById(R.id.addgroup_input);
            this.f20338d = editText;
            editText.setInputType(2);
            this.f20339e = (ImageButton) this.f20343i.findViewById(R.id.addgroup_delbtn);
            this.f20341g = this.f20343i.findViewById(R.id.addgroup_searchbutton);
            this.f20342h = this.f20343i.findViewById(R.id.addgroup_vcode);
            this.f20338d.addTextChangedListener(new C1010a(this));
            this.f20341g = this.f20343i.findViewById(R.id.addgroup_searchbutton);
            this.f20340f = (ProgressBar) this.f20343i.findViewById(R.id.addgroup_progress);
            this.f20337c.setOnClickListener(this.f20343i);
            this.f20339e.setOnClickListener(this.f20343i);
            this.f20341g.setOnClickListener(this.f20343i);
            this.f20342h.setOnClickListener(this.f20343i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f20342h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20341g : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20342h : (View) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f20340f.setVisibility(z ? 0 : 8);
        }
    }
}
