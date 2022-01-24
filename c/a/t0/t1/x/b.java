package c.a.t0.t1.x;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.d.a.f;
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
/* loaded from: classes8.dex */
public class b extends c.a.d.a.c<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f22556b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f22557c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22558d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22559e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22560f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22561g;

    /* renamed from: h  reason: collision with root package name */
    public ValidateActivity f22562h;

    /* renamed from: i  reason: collision with root package name */
    public ValidateItemData f22563i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22564e;

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
            this.f22564e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22564e.f22562h.onItemViewClick(this.f22564e.f22561g, 100, 0, 0L, this.f22564e.f22563i);
            }
        }
    }

    /* renamed from: c.a.t0.t1.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1393b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22565e;

        public View$OnClickListenerC1393b(b bVar) {
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
            this.f22565e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22565e.f22562h.onItemViewClick(this.f22565e.f22557c, 101, 0, 0L, this.f22565e.f22563i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22566e;

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
            this.f22566e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f22566e.f22562h.onItemViewLongClick(this.f22566e.f22556b, 200, 0, 0L, this.f22566e.f22563i);
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
        this.f22562h = validateActivity;
        j();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.a.findViewById(R.id.root_view);
            this.f22556b = findViewById;
            HeadImageView headImageView = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f22557c = headImageView;
            headImageView.setIsRound(false);
            this.f22558d = (TextView) this.f22556b.findViewById(R.id.tv_user_name);
            this.f22559e = (TextView) this.f22556b.findViewById(R.id.tv_group_name);
            this.f22560f = (TextView) this.f22556b.findViewById(R.id.tv_apply_reason);
            TextView textView = (TextView) this.f22556b.findViewById(R.id.btn_pass);
            this.f22561g = textView;
            textView.setOnClickListener(new a(this));
            this.f22557c.setOnClickListener(new View$OnClickListenerC1393b(this));
            this.f22556b.setOnLongClickListener(new c(this));
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
            this.f22563i = validateItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f22563i == null) {
            return;
        }
        this.f22562h.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f22562h.getLayoutMode().j(this.f22556b);
        String portrait = this.f22563i.getPortrait();
        this.f22557c.setTag(portrait);
        this.f22557c.startLoad(portrait, 12, false);
        if (!TextUtils.isEmpty(this.f22563i.getUserName())) {
            this.f22558d.setText(this.f22563i.getUserName());
        }
        if (!TextUtils.isEmpty(this.f22563i.getGroupName())) {
            TextView textView = this.f22559e;
            textView.setText(this.f22562h.getPageContext().getString(R.string.validate_im_apply_prefix) + this.f22563i.getGroupName());
        }
        if (!TextUtils.isEmpty(this.f22563i.getApplyReason())) {
            TextView textView2 = this.f22560f;
            textView2.setText(this.f22562h.getPageContext().getString(R.string.validate_im_reason_prefix) + this.f22563i.getApplyReason());
        }
        if (this.f22563i.isPass()) {
            this.f22561g.setEnabled(false);
            this.f22561g.setText(this.f22562h.getPageContext().getString(R.string.passed));
            SkinManager.setViewTextColor(this.f22561g, R.color.CAM_X0109);
            this.f22561g.setBackgroundDrawable(null);
        } else {
            this.f22561g.setEnabled(true);
            this.f22561g.setText(this.f22562h.getPageContext().getString(R.string.pass));
        }
        if (this.f22563i.isShown()) {
            return;
        }
        SkinManager.setBackgroundResource(this.f22556b, R.color.common_color_10178);
    }
}
