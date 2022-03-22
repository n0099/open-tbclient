package c.a.p0.f4.e;

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
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f15047b;

    /* renamed from: c  reason: collision with root package name */
    public BdExpandImageView f15048c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f15049d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15050e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15051f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f15052g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15053h;
    public final c.a.d.f.l.c<c.a.d.o.d.a> i;

    /* loaded from: classes2.dex */
    public class a extends c.a.d.f.l.c<c.a.d.o.d.a> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) || aVar == null) {
                return;
            }
            aVar.h(this.a.f15048c);
        }
    }

    public i(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0133, (ViewGroup) null);
        this.f15047b = inflate;
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bf)));
        c();
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15047b : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f15048c = (BdExpandImageView) this.f15047b.findViewById(R.id.obfuscated_res_0x7f090931);
            this.f15049d = (TbImageView) this.f15047b.findViewById(R.id.obfuscated_res_0x7f0922a1);
            TbImageView tbImageView = (TbImageView) this.f15047b.findViewById(R.id.obfuscated_res_0x7f0923f6);
            this.f15050e = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.f15051f = (TextView) this.f15047b.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.f15052g = (ImageView) this.f15047b.findViewById(R.id.obfuscated_res_0x7f0922d4);
            this.f15053h = (TextView) this.f15047b.findViewById(R.id.obfuscated_res_0x7f092299);
            this.f15049d.setDefaultResource(R.drawable.icon_default_avatar100);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.getPageContext() == null) {
            return;
        }
        c.a.o0.w0.a.a(this.a.getPageContext(), this.f15047b);
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        c.a.d.f.l.d.h().k(dressItemData.getExampleImgUrl(), 10, this.i, 0, 0, null, new Object[0]);
        if (StringUtils.isNull(dressItemData.getPropsStateImg())) {
            this.f15053h.setText("0");
        } else {
            this.f15053h.setText(dressItemData.getPropsStateImg());
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            SkinManager.setViewTextColor(this.f15053h, R.color.CAM_X0308, 1);
            this.f15051f.setText(R.string.obfuscated_res_0x7f0f0480);
            this.f15052g.setImageResource(R.drawable.icon_pop_boy);
            this.f15050e.setVisibility(8);
            return;
        }
        String avatar = currentAccountInfo.getAvatar();
        int memberType = currentAccountInfo.getMemberType();
        if (!TextUtils.isEmpty(avatar)) {
            this.f15049d.J(avatar, 25, false);
        }
        String memberIconUrl = currentAccountInfo.getMemberIconUrl();
        if (StringUtils.isNull(memberIconUrl)) {
            this.f15050e.setVisibility(8);
        } else {
            this.f15050e.J(memberIconUrl, 10, false);
            this.f15050e.setVisibility(0);
        }
        if (memberType > 0) {
            this.f15051f.setTextColor(this.a.getResources().getColor(R.color.CAM_X0308));
        } else {
            this.f15051f.setTextColor(this.a.getResources().getColor(R.color.CAM_X0111));
        }
        this.f15051f.setText(currentAccountInfo.getAccountNameShow());
        int sex = currentAccountInfo.getSex();
        if (sex == 1) {
            this.f15052g.setImageResource(R.drawable.icon_pop_boy);
        } else if (sex == 2) {
            this.f15052g.setImageResource(R.drawable.icon_pop_girl);
        } else {
            this.f15052g.setVisibility(8);
        }
    }
}
