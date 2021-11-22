package b.a.r0.s3.e;

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
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f24940a;

    /* renamed from: b  reason: collision with root package name */
    public View f24941b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f24942c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f24943d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f24944e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24945f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f24946g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24947h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a.e.f.l.c<b.a.e.m.d.a> f24948i;

    /* loaded from: classes5.dex */
    public class a extends b.a.e.f.l.c<b.a.e.m.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f24949a;

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
            this.f24949a = iVar;
        }

        @Override // b.a.e.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // b.a.e.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.l.c
        public void onLoaded(b.a.e.m.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            aVar.h(this.f24949a.f24942c);
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
        this.f24948i = new a(this);
        this.f24940a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f24941b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f24940a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24941b : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24942c = (BdExpandImageView) this.f24941b.findViewById(R.id.expand_image);
            this.f24943d = (TbImageView) this.f24941b.findViewById(R.id.user_head);
            TbImageView tbImageView = (TbImageView) this.f24941b.findViewById(R.id.vip_icon);
            this.f24944e = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f24945f = (TextView) this.f24941b.findViewById(R.id.user_name);
            this.f24946g = (ImageView) this.f24941b.findViewById(R.id.user_sex);
            this.f24947h = (TextView) this.f24941b.findViewById(R.id.user_bar_age_num);
            this.f24943d.setDefaultResource(R.drawable.icon_default_avatar100);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f24940a.getPageContext() == null) {
            return;
        }
        b.a.q0.v0.a.a(this.f24940a.getPageContext(), this.f24941b);
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        b.a.e.f.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f24948i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f24947h.setText("0");
        } else {
            this.f24947h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f24947h, R.color.CAM_X0308, 1);
            this.f24945f.setText(R.string.default_user_name);
            this.f24946g.setImageResource(R.drawable.icon_pop_boy);
            this.f24944e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f24943d.startLoad(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f24944e.setVisibility(8);
        } else {
            this.f24944e.startLoad(memberIconUrl, 10, false);
            this.f24944e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f24945f.setTextColor(this.f24940a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f24945f.setTextColor(this.f24940a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f24945f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f24946g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f24946g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f24946g.setVisibility(8);
        }
    }
}
