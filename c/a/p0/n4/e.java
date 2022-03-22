package c.a.p0.n4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.SendVideoSuccessShareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public Context f16600b;

    /* renamed from: c  reason: collision with root package name */
    public View f16601c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16602d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16603e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16604f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f16605g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16606h;
    public SendVideoSuccessShareModel i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.f16604f) {
                this.a.f();
                if (this.a.f16605g == null || StringUtils.isNull(this.a.f16605g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                c.a.o0.l.a.n(this.a.f16600b, null, this.a.f16605g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* loaded from: classes2.dex */
        public class a extends c.a.d.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.f0 = false;
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                    c.a.p0.l0.h.c().l(new ShareDialogConfig(this.a.a.f16600b, shareItem, true, true));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param(TiebaStatic.Params.OBJ_PARAM3, 1));
                }
            }
        }

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f();
                if (this.a.f16605g == null || StringUtils.isNull(this.a.f16605g.getVideoid())) {
                    return;
                }
                this.a.i.A(this.a.f16605g.getVideoid());
                this.a.i.setLoadDataCallBack(new a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public e(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16600b = context;
        this.f16601c = viewGroup;
        this.i = new SendVideoSuccessShareModel();
        if (this.f16600b == null || this.f16601c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d076c, (ViewGroup) null);
        this.a = inflate;
        this.f16602d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ddd);
        this.f16603e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092301);
        this.f16606h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092376);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, n.f(context, R.dimen.obfuscated_res_0x7f0701aa));
        if (this.a.getParent() == null) {
            viewGroup.addView(this.a, layoutParams);
        }
        this.a.setVisibility(8);
        this.a.setOnClickListener(new a(this));
        this.f16606h.setOnClickListener(new b(this));
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sendVideoSuccessShareModel = this.i) == null) {
            return;
        }
        sendVideoSuccessShareModel.cancelLoadData();
    }

    public void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.a) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f16605g = postWriteCallBackData;
        this.f16604f = postWriteCallBackData.mVideoTitleData != null;
        View view = this.a;
        if (view == null || this.f16602d == null || this.f16603e == null || this.f16606h == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f16602d, (int) R.color.CAM_X0101);
        SkinManager.setImageResource(this.f16603e, R.drawable.icon_arrow_more_white);
        SkinManager.setBackgroundResource(this.f16606h, R.drawable.immediately_share_background);
        this.a.setVisibility(0);
        this.a.postDelayed(new c(this), 5000L);
        if (this.f16604f) {
            this.f16602d.setText(R.string.obfuscated_res_0x7f0f14bd);
        } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
            this.f16602d.setText(postWriteCallBackData.getErrorString());
        } else {
            this.a.setVisibility(8);
        }
    }
}
