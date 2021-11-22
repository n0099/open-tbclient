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
    public View f21857a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f21858b;

    /* renamed from: c  reason: collision with root package name */
    public View f21859c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f21860d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f21861e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f21862f;

    /* renamed from: g  reason: collision with root package name */
    public View f21863g;

    /* renamed from: h  reason: collision with root package name */
    public View f21864h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f21865i;

    /* renamed from: b.a.r0.l1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1078a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21866e;

        public C1078a(a aVar) {
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
            this.f21866e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f21866e.f21863g.setTag(editable.toString().trim());
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
                if (this.f21866e.f21860d.length() > 0) {
                    this.f21866e.f21861e.setVisibility(0);
                } else {
                    this.f21866e.f21861e.setVisibility(8);
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
        this.f21857a = null;
        this.f21858b = null;
        this.f21859c = null;
        this.f21860d = null;
        this.f21861e = null;
        this.f21862f = null;
        this.f21863g = null;
        this.f21865i = null;
        this.f21865i = addGroupActivity;
        initUI();
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f21865i.getLayoutMode().k(i2 == 1);
            this.f21865i.getLayoutMode().j(this.f21857a);
            this.f21858b.onChangeSkinType(this.f21865i.getPageContext(), i2);
        }
    }

    public void g() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f21860d) == null) {
            return;
        }
        editText.setText("");
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21859c : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21861e : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21865i.setContentView(R.layout.im_add_group_activity);
            this.f21857a = this.f21865i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f21865i.findViewById(R.id.addgroup_navigationbar);
            this.f21858b = navigationBar;
            this.f21859c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21858b.setTitleText(this.f21865i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f21865i.findViewById(R.id.addgroup_input);
            this.f21860d = editText;
            editText.setInputType(2);
            this.f21861e = (ImageButton) this.f21865i.findViewById(R.id.addgroup_delbtn);
            this.f21863g = this.f21865i.findViewById(R.id.addgroup_searchbutton);
            this.f21864h = this.f21865i.findViewById(R.id.addgroup_vcode);
            this.f21860d.addTextChangedListener(new C1078a(this));
            this.f21863g = this.f21865i.findViewById(R.id.addgroup_searchbutton);
            this.f21862f = (ProgressBar) this.f21865i.findViewById(R.id.addgroup_progress);
            this.f21859c.setOnClickListener(this.f21865i);
            this.f21861e.setOnClickListener(this.f21865i);
            this.f21863g.setOnClickListener(this.f21865i);
            this.f21864h.setOnClickListener(this.f21865i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f21864h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21863g : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21864h : (View) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f21862f.setVisibility(z ? 0 : 8);
        }
    }
}
