package c.a.p0.j1.r;

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
    public View f20660a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f20661b;

    /* renamed from: c  reason: collision with root package name */
    public View f20662c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f20663d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f20664e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f20665f;

    /* renamed from: g  reason: collision with root package name */
    public View f20666g;

    /* renamed from: h  reason: collision with root package name */
    public View f20667h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f20668i;

    /* renamed from: c.a.p0.j1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0965a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20669e;

        public C0965a(a aVar) {
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
            this.f20669e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f20669e.f20666g.setTag(editable.toString().trim());
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
                if (this.f20669e.f20663d.length() > 0) {
                    this.f20669e.f20664e.setVisibility(0);
                } else {
                    this.f20669e.f20664e.setVisibility(8);
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
        this.f20660a = null;
        this.f20661b = null;
        this.f20662c = null;
        this.f20663d = null;
        this.f20664e = null;
        this.f20665f = null;
        this.f20666g = null;
        this.f20668i = null;
        this.f20668i = addGroupActivity;
        initUI();
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f20668i.getLayoutMode().k(i2 == 1);
            this.f20668i.getLayoutMode().j(this.f20660a);
            this.f20661b.onChangeSkinType(this.f20668i.getPageContext(), i2);
        }
    }

    public void g() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f20663d) == null) {
            return;
        }
        editText.setText("");
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20662c : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20664e : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f20668i.setContentView(R.layout.im_add_group_activity);
            this.f20660a = this.f20668i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f20668i.findViewById(R.id.addgroup_navigationbar);
            this.f20661b = navigationBar;
            this.f20662c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20661b.setTitleText(this.f20668i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f20668i.findViewById(R.id.addgroup_input);
            this.f20663d = editText;
            editText.setInputType(2);
            this.f20664e = (ImageButton) this.f20668i.findViewById(R.id.addgroup_delbtn);
            this.f20666g = this.f20668i.findViewById(R.id.addgroup_searchbutton);
            this.f20667h = this.f20668i.findViewById(R.id.addgroup_vcode);
            this.f20663d.addTextChangedListener(new C0965a(this));
            this.f20666g = this.f20668i.findViewById(R.id.addgroup_searchbutton);
            this.f20665f = (ProgressBar) this.f20668i.findViewById(R.id.addgroup_progress);
            this.f20662c.setOnClickListener(this.f20668i);
            this.f20664e.setOnClickListener(this.f20668i);
            this.f20666g.setOnClickListener(this.f20668i);
            this.f20667h.setOnClickListener(this.f20668i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f20667h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20666g : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20667h : (View) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f20665f.setVisibility(z ? 0 : 8);
        }
    }
}
