package c.a.t0.c4.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15698b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f15699c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f15700d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15701e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15702f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15703g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15704h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.d.f.l.c<c.a.d.n.d.a> f15705i;

    /* loaded from: classes7.dex */
    public class a extends c.a.d.f.l.c<c.a.d.n.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.d.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.n.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            aVar.h(this.a.f15699c);
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15705i = new a(this);
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f15698b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15698b : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15699c = (BdExpandImageView) this.f15698b.findViewById(R.id.expand_image);
            this.f15700d = (TbImageView) this.f15698b.findViewById(R.id.user_head);
            TbImageView tbImageView = (TbImageView) this.f15698b.findViewById(R.id.vip_icon);
            this.f15701e = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f15702f = (TextView) this.f15698b.findViewById(R.id.user_name);
            this.f15703g = (ImageView) this.f15698b.findViewById(R.id.user_sex);
            this.f15704h = (TextView) this.f15698b.findViewById(R.id.user_bar_age_num);
            this.f15700d.setDefaultResource(R.drawable.icon_default_avatar100);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.getPageContext() == null) {
            return;
        }
        c.a.s0.x0.a.a(this.a.getPageContext(), this.f15698b);
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        c.a.d.f.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f15705i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f15704h.setText("0");
        } else {
            this.f15704h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f15704h, R.color.CAM_X0308, 1);
            this.f15702f.setText(R.string.default_user_name);
            this.f15703g.setImageResource(R.drawable.icon_pop_boy);
            this.f15701e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f15700d.startLoad(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f15701e.setVisibility(8);
        } else {
            this.f15701e.startLoad(memberIconUrl, 10, false);
            this.f15701e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f15702f.setTextColor(this.a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f15702f.setTextColor(this.a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f15702f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f15703g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f15703g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f15703g.setVisibility(8);
        }
    }
}
