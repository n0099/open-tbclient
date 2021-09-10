package c.a.r0.p3.e;

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
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f23946a;

    /* renamed from: b  reason: collision with root package name */
    public View f23947b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f23948c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f23949d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f23950e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23951f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23952g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23953h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.e.e.l.c<c.a.e.l.d.a> f23954i;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f23955a;

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
            this.f23955a = iVar;
        }

        @Override // c.a.e.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
            }
        }

        @Override // c.a.e.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            aVar.h(this.f23955a.f23948c);
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
        this.f23954i = new a(this);
        this.f23946a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview_header, (ViewGroup) null);
        this.f23947b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.f23946a.getResources().getDimensionPixelSize(R.dimen.ds450)));
        c();
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23947b : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f23948c = (BdExpandImageView) this.f23947b.findViewById(R.id.expand_image);
            this.f23949d = (TbImageView) this.f23947b.findViewById(R.id.user_head);
            TbImageView tbImageView = (TbImageView) this.f23947b.findViewById(R.id.vip_icon);
            this.f23950e = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f23951f = (TextView) this.f23947b.findViewById(R.id.user_name);
            this.f23952g = (ImageView) this.f23947b.findViewById(R.id.user_sex);
            this.f23953h = (TextView) this.f23947b.findViewById(R.id.user_bar_age_num);
            this.f23949d.setDefaultResource(R.drawable.icon_default_avatar100);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f23946a.getPageContext() == null) {
            return;
        }
        c.a.q0.w0.a.a(this.f23946a.getPageContext(), this.f23947b);
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        c.a.e.e.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.f23954i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f23953h.setText("0");
        } else {
            this.f23953h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f23953h, R.color.CAM_X0308, 1);
            this.f23951f.setText(R.string.default_user_name);
            this.f23952g.setImageResource(R.drawable.icon_pop_boy);
            this.f23950e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f23949d.startLoad(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f23950e.setVisibility(8);
        } else {
            this.f23950e.startLoad(memberIconUrl, 10, false);
            this.f23950e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f23951f.setTextColor(this.f23946a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f23951f.setTextColor(this.f23946a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f23951f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f23952g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f23952g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f23952g.setVisibility(8);
        }
    }
}
