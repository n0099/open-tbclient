package b.a.r0.l1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import b.a.e.a.f;
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
/* loaded from: classes5.dex */
public class b extends b.a.e.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f21956b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21957c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21958d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21959e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21960f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21961g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f21962h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f21963i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21964e;

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
            this.f21964e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21964e.f21962h.onItemViewClick(this.f21964e.f21961g, 100, 0, 0L, this.f21964e.f21963i);
            }
        }
    }

    /* renamed from: b.a.r0.l1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1084b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21965e;

        public View$OnClickListenerC1084b(b bVar) {
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
            this.f21965e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21965e.f21962h.onItemViewClick(this.f21965e.f21957c, 101, 0, 0L, this.f21965e.f21963i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21966e;

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
            this.f21966e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21966e.f21962h.onItemViewLongClick(this.f21966e.f21956b, 200, 0, 0L, this.f21966e.f21963i);
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
        this.f21962h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1459a.findViewById(R.id.root_view);
            this.f21956b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21957c = headImageView;
            headImageView.setIsRound(false);
            this.f21958d = (TextView) this.f21956b.findViewById(R.id.tv_user_name);
            this.f21959e = (TextView) this.f21956b.findViewById(R.id.tv_group_name);
            this.f21960f = (TextView) this.f21956b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f21956b.findViewById(R.id.btn_pass);
            this.f21961g = textView;
            textView.setOnClickListener(new a(this));
            this.f21957c.setOnClickListener(new View$OnClickListenerC1084b(this));
            this.f21956b.setOnLongClickListener(new c(this));
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
            this.f21963i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f21963i == null) {
            return;
        }
        this.f21962h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f21962h.getLayoutMode().j(this.f21956b);
        String portrait = this.f21963i.getPortrait();
        this.f21957c.setTag(portrait);
        this.f21957c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f21963i.getUserName())) {
            this.f21958d.setText(this.f21963i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f21963i.getGroupName())) {
            TextView textView = this.f21959e;
            textView.setText(this.f21962h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f21963i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f21963i.getApplyReason())) {
            TextView textView2 = this.f21960f;
            textView2.setText(this.f21962h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f21963i.getApplyReason());
        }
        if (this.f21963i.isPass()) {
            this.f21961g.setEnabled(false);
            this.f21961g.setText(this.f21962h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f21961g, R.color.CAM_X0109);
            this.f21961g.setBackgroundDrawable(null);
        } else {
            this.f21961g.setEnabled(true);
            this.f21961g.setText(this.f21962h.getPageContext().getString(R.string.pass));
        }
        if (this.f21963i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f21956b, R.color.common_color_10178);
    }
}
