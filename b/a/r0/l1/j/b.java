package b.a.r0.l1.j;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class b extends b.a.e.a.c<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f21732b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f21733c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21734d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21735e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21736f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21737g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21738h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f21739i;
    public RelativeLayout j;
    public UpdatesActivity k;
    public UpdatesItemData l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* renamed from: b.a.r0.l1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1069b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21740e;

        public View$OnClickListenerC1069b(b bVar) {
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
            this.f21740e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21740e.k.isEditMode()) {
                    this.f21740e.f21738h.performClick();
                } else {
                    this.f21740e.k.onItemViewClick(this.f21740e.f21732b, 101, 0, 0L, this.f21740e.l);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21741e;

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
            this.f21741e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21741e.k.onItemViewLongClick(this.f21741e.f21732b, 200, 0, 0L, this.f21741e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21742e;

        public d(b bVar) {
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
            this.f21742e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21742e.k.onItemViewClick(this.f21742e.f21732b, 101, 0, 0L, this.f21742e.l);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21743e;

        public e(b bVar) {
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
            this.f21743e = bVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21743e.k.onItemViewLongClick(this.f21743e.f21732b, 200, 0, 0L, this.f21743e.l);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21744e;

        public f(b bVar) {
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
            this.f21744e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setSelected(!view.isSelected());
                this.f21744e.k.onCheckedChanged(view, view.isSelected(), this.f21744e.l);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext(), R.layout.updates_item);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b.a.e.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = updatesActivity;
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = this.f1459a.findViewById(R.id.root_view);
            this.f21732b = findViewById;
            this.f21733c = (HeadImageView) findViewById.findViewById(R.id.iv_head);
            this.f21734d = (TextView) this.f21732b.findViewById(R.id.tv_group_name);
            this.f21735e = (TextView) this.f21732b.findViewById(R.id.tv_content);
            this.f21736f = (TextView) this.f21732b.findViewById(R.id.tv_title);
            this.f21737g = (TextView) this.f21732b.findViewById(R.id.tv_time);
            this.f21738h = (ImageView) this.f21732b.findViewById(R.id.cb_select);
            this.f21739i = (RelativeLayout) this.f21732b.findViewById(R.id.layout_body);
            this.j = (RelativeLayout) this.f21732b.findViewById(R.id.layout_title);
            this.f21733c.setOnClickListener(new a(this));
            this.f21739i.setClickable(true);
            this.f21739i.setLongClickable(true);
            this.j.setClickable(true);
            this.j.setLongClickable(true);
            this.f21739i.setOnClickListener(new View$OnClickListenerC1069b(this));
            this.f21739i.setOnLongClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            this.j.setOnLongClickListener(new e(this));
            this.f21738h.setOnClickListener(new f(this));
        }
    }

    public void j(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, updatesItemData) == null) {
            k(updatesItemData);
            refresh();
        }
    }

    public void k(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, updatesItemData) == null) {
            this.l = updatesItemData;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.l == null) {
            return;
        }
        if (this.k.isEditMode()) {
            this.f21738h.setVisibility(0);
        } else {
            this.f21738h.setVisibility(8);
            this.f21739i.setSelected(false);
        }
        String groupHeadUrl = this.l.getGroupHeadUrl();
        if (!TextUtils.isEmpty(groupHeadUrl)) {
            this.f21733c.setTag(groupHeadUrl);
            this.f21733c.startLoad(groupHeadUrl, 10, false);
        } else {
            this.f21733c.setTag(null);
        }
        this.f21733c.setClickable(false);
        if (!TextUtils.isEmpty(this.l.getTitle())) {
            this.f21736f.setText(this.l.getTitle());
        } else {
            this.f21736f.setText(this.k.getPageContext().getString(R.string.inform));
        }
        Date date = new Date();
        date.setTime(this.l.getTime());
        this.f21737g.setText(StringHelper.getPostTimeString(date));
        if (!TextUtils.isEmpty(this.l.getContent())) {
            this.f21735e.setText(this.l.getContent());
        } else {
            this.f21735e.setText("");
        }
        if (!TextUtils.isEmpty(this.l.getGroupName())) {
            this.f21734d.setText(this.l.getGroupName());
        } else {
            this.f21734d.setText("");
        }
        int paddingLeft = this.f21739i.getPaddingLeft();
        int paddingTop = this.f21739i.getPaddingTop();
        int paddingRight = this.f21739i.getPaddingRight();
        int paddingBottom = this.f21739i.getPaddingBottom();
        this.k.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.k.getLayoutMode().j(this.f1459a);
        this.f21738h.setSelected(this.l.isSelected());
        if (this.l.isSelected() && this.k.isEditMode()) {
            SkinManager.setBackgroundResource(this.f21739i, R.drawable.bg_information_down_s);
        } else {
            SkinManager.setBackgroundResource(this.f21739i, R.drawable.selector_group_updates_bottom_bg);
        }
        this.f21739i.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
