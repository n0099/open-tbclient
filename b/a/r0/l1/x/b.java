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
    public View f20434b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f20435c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20436d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20437e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20438f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20439g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f20440h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f20441i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20442e;

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
            this.f20442e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20442e.f20440h.onItemViewClick(this.f20442e.f20439g, 100, 0, 0L, this.f20442e.f20441i);
            }
        }
    }

    /* renamed from: b.a.r0.l1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1016b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20443e;

        public View$OnClickListenerC1016b(b bVar) {
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
            this.f20443e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20443e.f20440h.onItemViewClick(this.f20443e.f20435c, 101, 0, 0L, this.f20443e.f20441i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20444e;

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
            this.f20444e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f20444e.f20440h.onItemViewLongClick(this.f20444e.f20434b, 200, 0, 0L, this.f20444e.f20441i);
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
        this.f20440h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1463a.findViewById(R.id.root_view);
            this.f20434b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f20435c = headImageView;
            headImageView.setIsRound(false);
            this.f20436d = (TextView) this.f20434b.findViewById(R.id.tv_user_name);
            this.f20437e = (TextView) this.f20434b.findViewById(R.id.tv_group_name);
            this.f20438f = (TextView) this.f20434b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f20434b.findViewById(R.id.btn_pass);
            this.f20439g = textView;
            textView.setOnClickListener(new a(this));
            this.f20435c.setOnClickListener(new View$OnClickListenerC1016b(this));
            this.f20434b.setOnLongClickListener(new c(this));
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
            this.f20441i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f20441i == null) {
            return;
        }
        this.f20440h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f20440h.getLayoutMode().j(this.f20434b);
        String portrait = this.f20441i.getPortrait();
        this.f20435c.setTag(portrait);
        this.f20435c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f20441i.getUserName())) {
            this.f20436d.setText(this.f20441i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f20441i.getGroupName())) {
            TextView textView = this.f20437e;
            textView.setText(this.f20440h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f20441i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f20441i.getApplyReason())) {
            TextView textView2 = this.f20438f;
            textView2.setText(this.f20440h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f20441i.getApplyReason());
        }
        if (this.f20441i.isPass()) {
            this.f20439g.setEnabled(false);
            this.f20439g.setText(this.f20440h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f20439g, R.color.CAM_X0109);
            this.f20439g.setBackgroundDrawable(null);
        } else {
            this.f20439g.setEnabled(true);
            this.f20439g.setText(this.f20440h.getPageContext().getString(R.string.pass));
        }
        if (this.f20441i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f20434b, R.color.common_color_10178);
    }
}
