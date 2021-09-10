package c.a.r0.k1.r;

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
    public View f21560a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f21561b;

    /* renamed from: c  reason: collision with root package name */
    public View f21562c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f21563d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f21564e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f21565f;

    /* renamed from: g  reason: collision with root package name */
    public View f21566g;

    /* renamed from: h  reason: collision with root package name */
    public View f21567h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f21568i;

    /* renamed from: c.a.r0.k1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1009a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21569e;

        public C1009a(a aVar) {
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
            this.f21569e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f21569e.f21566g.setTag(editable.toString().trim());
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
                if (this.f21569e.f21563d.length() > 0) {
                    this.f21569e.f21564e.setVisibility(0);
                } else {
                    this.f21569e.f21564e.setVisibility(8);
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
        this.f21560a = null;
        this.f21561b = null;
        this.f21562c = null;
        this.f21563d = null;
        this.f21564e = null;
        this.f21565f = null;
        this.f21566g = null;
        this.f21568i = null;
        this.f21568i = addGroupActivity;
        initUI();
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f21568i.getLayoutMode().k(i2 == 1);
            this.f21568i.getLayoutMode().j(this.f21560a);
            this.f21561b.onChangeSkinType(this.f21568i.getPageContext(), i2);
        }
    }

    public void g() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.f21563d) == null) {
            return;
        }
        editText.setText("");
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21562c : (View) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21564e : (View) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21568i.setContentView(R.layout.im_add_group_activity);
            this.f21560a = this.f21568i.findViewById(R.id.addgroup_rootlayout);
            NavigationBar navigationBar = (NavigationBar) this.f21568i.findViewById(R.id.addgroup_navigationbar);
            this.f21561b = navigationBar;
            this.f21562c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21561b.setTitleText(this.f21568i.getResources().getString(R.string.add_group_title_main));
            EditText editText = (EditText) this.f21568i.findViewById(R.id.addgroup_input);
            this.f21563d = editText;
            editText.setInputType(2);
            this.f21564e = (ImageButton) this.f21568i.findViewById(R.id.addgroup_delbtn);
            this.f21566g = this.f21568i.findViewById(R.id.addgroup_searchbutton);
            this.f21567h = this.f21568i.findViewById(R.id.addgroup_vcode);
            this.f21563d.addTextChangedListener(new C1009a(this));
            this.f21566g = this.f21568i.findViewById(R.id.addgroup_searchbutton);
            this.f21565f = (ProgressBar) this.f21568i.findViewById(R.id.addgroup_progress);
            this.f21562c.setOnClickListener(this.f21568i);
            this.f21564e.setOnClickListener(this.f21568i);
            this.f21566g.setOnClickListener(this.f21568i);
            this.f21567h.setOnClickListener(this.f21568i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.f21567h.setVisibility(8);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21566g : (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21567h : (View) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f21565f.setVisibility(z ? 0 : 8);
        }
    }
}
