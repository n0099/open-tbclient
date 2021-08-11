package c.a.p0.j1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.e.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.e.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f20760b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f20761c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20762d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20763e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20764f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20765g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f20766h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f20767i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20768e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20768e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20768e.f20766h.onItemViewClick(this.f20768e.f20765g, 100, 0, 0L, this.f20768e.f20767i);
            }
        }
    }

    /* renamed from: c.a.p0.j1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0971b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20769e;

        public View$OnClickListenerC0971b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20769e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20769e.f20766h.onItemViewClick(this.f20769e.f20761c, 101, 0, 0L, this.f20769e.f20767i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20770e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20770e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20770e.f20766h.onItemViewLongClick(this.f20770e.f20760b, 200, 0, 0L, this.f20770e.f20767i);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20766h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1918a.findViewById(R.id.root_view);
            this.f20760b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f20761c = headImageView;
            headImageView.setIsRound(false);
            this.f20762d = (TextView) this.f20760b.findViewById(R.id.tv_user_name);
            this.f20763e = (TextView) this.f20760b.findViewById(R.id.tv_group_name);
            this.f20764f = (TextView) this.f20760b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f20760b.findViewById(R.id.btn_pass);
            this.f20765g = textView;
            textView.setOnClickListener(new a(this));
            this.f20761c.setOnClickListener(new View$OnClickListenerC0971b(this));
            this.f20760b.setOnLongClickListener(new c(this));
        }
    }

    public void k(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, validateItemData) == null) {
            l(validateItemData);
            refresh();
        }
    }

    public void l(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, validateItemData) == null) {
            this.f20767i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f20767i == null) {
            return;
        }
        this.f20766h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f20766h.getLayoutMode().j(this.f20760b);
        String portrait = this.f20767i.getPortrait();
        this.f20761c.setTag(portrait);
        this.f20761c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f20767i.getUserName())) {
            this.f20762d.setText(this.f20767i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f20767i.getGroupName())) {
            TextView textView = this.f20763e;
            textView.setText(this.f20766h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f20767i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f20767i.getApplyReason())) {
            TextView textView2 = this.f20764f;
            textView2.setText(this.f20766h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f20767i.getApplyReason());
        }
        if (this.f20767i.isPass()) {
            this.f20765g.setEnabled(false);
            this.f20765g.setText(this.f20766h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f20765g, R.color.CAM_X0109);
            this.f20765g.setBackgroundDrawable(null);
        } else {
            this.f20765g.setEnabled(true);
            this.f20765g.setText(this.f20766h.getPageContext().getString(R.string.pass));
        }
        if (this.f20767i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f20760b, R.color.common_color_10178);
    }
}
