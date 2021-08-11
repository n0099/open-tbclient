package c.a.p0.w3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f27863a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27864b;

    /* renamed from: c  reason: collision with root package name */
    public View f27865c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27866d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f27867e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27868f;

    /* renamed from: g  reason: collision with root package name */
    public PostWriteCallBackData f27869g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27870h;

    /* renamed from: i  reason: collision with root package name */
    public SendVideoSuccessShareModel f27871i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27872e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27872e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f27872e.f27868f) {
                this.f27872e.f();
                if (this.f27872e.f27869g == null || StringUtils.isNull(this.f27872e.f27869g.buildVideoFakeOnWallUrl())) {
                    return;
                }
                c.a.o0.m.a.m(this.f27872e.f27864b, null, this.f27872e.f27869g.buildVideoFakeOnWallUrl());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27873e;

        /* loaded from: classes4.dex */
        public class a extends c.a.e.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f27874a;

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
                this.f27874a = bVar;
            }

            @Override // c.a.e.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    ShareItem shareItem = new ShareItem();
                    shareItem.a0 = false;
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                    c.a.p0.e0.f.b().k(new ShareDialogConfig(this.f27874a.f27873e.f27864b, shareItem, true, true));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27873e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27873e.f();
                if (this.f27873e.f27869g == null || StringUtils.isNull(this.f27873e.f27869g.getVideoid())) {
                    return;
                }
                this.f27873e.f27871i.y(this.f27873e.f27869g.getVideoid());
                this.f27873e.f27871i.setLoadDataCallBack(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27875e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27875e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27875e.f();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27864b = context;
        this.f27865c = viewGroup;
        this.f27871i = new SendVideoSuccessShareModel();
        if (this.f27864b == null || this.f27865c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
        this.f27863a = inflate;
        this.f27866d = (TextView) inflate.findViewById(R.id.success_tip);
        this.f27867e = (ImageView) this.f27863a.findViewById(R.id.video_activity_btn);
        this.f27870h = (TextView) this.f27863a.findViewById(R.id.video_share_btn);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
        if (this.f27863a.getParent() == null) {
            viewGroup.addView(this.f27863a, layoutParams);
        }
        this.f27863a.setVisibility(8);
        this.f27863a.setOnClickListener(new a(this));
        this.f27870h.setOnClickListener(new b(this));
    }

    public void e() {
        SendVideoSuccessShareModel sendVideoSuccessShareModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (sendVideoSuccessShareModel = this.f27871i) == null) {
            return;
        }
        sendVideoSuccessShareModel.cancelLoadData();
    }

    public void f() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (view = this.f27863a) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
        this.f27869g = postWriteCallBackData;
        this.f27868f = postWriteCallBackData.mVideoTitleData != null;
        View view = this.f27863a;
        if (view == null || this.f27866d == null || this.f27867e == null || this.f27870h == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f27866d, R.color.CAM_X0101);
        SkinManager.setImageResource(this.f27867e, R.drawable.icon_arrow_more_white);
        SkinManager.setBackgroundResource(this.f27870h, R.drawable.immediately_share_background);
        this.f27863a.setVisibility(0);
        this.f27863a.postDelayed(new c(this), 5000L);
        if (this.f27868f) {
            this.f27866d.setText(R.string.video_activity_tip);
        } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
            this.f27866d.setText(postWriteCallBackData.getErrorString());
        } else {
            this.f27863a.setVisibility(8);
        }
    }
}
