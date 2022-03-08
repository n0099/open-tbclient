package c.a.r0.u2.k.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.c1.o0;
import c.a.q0.r.r.e2;
import c.a.r0.f0.m;
import c.a.r0.u2.i.c;
import c.a.r0.u2.k.f.e1.c;
import c.a.r0.u2.k.f.s0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.s A;
    public c.a.d.f.k.b<ConstrainImageLayout> B;
    public c.a.d.f.k.b<TbImageView> C;
    public c.a.r0.u2.i.c D;
    public int m;
    public TbPageContext n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public c.a.r0.u2.i.c r;
    public View.OnLongClickListener s;
    public String t;
    public c.a.r0.u2.h.f u;
    public boolean v;
    public SparseIntArray w;
    public c.a.r0.u2.k.h.b x;
    public c.a.r0.u2.k.f.e1.a y;
    public c.a.r0.u2.k.f.e1.c z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23219e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f23220f;

        public a(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23219e = pbCommenFloorItemViewHolder;
            this.f23220f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f23219e.ownerInfoRootView.getMeasuredWidth();
                String str = this.f23220f;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.f23219e;
                s0.a(measuredWidth, str, pbCommenFloorItemViewHolder.mUserNameView, pbCommenFloorItemViewHolder.mFloorAuthorView, pbCommenFloorItemViewHolder.mForumLevelIcon, pbCommenFloorItemViewHolder.mTshowIconBox, pbCommenFloorItemViewHolder.mVipIconBox);
            }
        }
    }

    /* renamed from: c.a.r0.u2.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1442b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f23221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f23222f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f23223g;

        public View$OnClickListenerC1442b(b bVar, String str, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23223g = bVar;
            this.f23221e = str;
            this.f23222f = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23221e != null) {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f23223g.n.getPageActivity(), "", this.f23221e, true);
                    tbWebViewActivityConfig.setFixTitle(true);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
                if (this.f23223g.u != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.f23223g.u.m());
                    statisticItem.param("fname", this.f23223g.u.n());
                    statisticItem.param("tid", this.f23223g.u.Q());
                    statisticItem.param("pid", this.f23222f.G());
                    statisticItem.param("obj_type", this.f23222f.C());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.d.f.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.f3076e) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.d.f.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.f3076e);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.r != null) {
                    if (!(view instanceof TbListTextView) || this.a.p == null) {
                        this.a.r.a(view);
                        this.a.r.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.p.onClick(view);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.u2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (view != null) {
                    if (view instanceof RelativeLayout) {
                        this.a.m0(view);
                        return true;
                    }
                    ViewParent parent = view.getParent();
                    for (int i2 = 0; parent != null && i2 < 10; i2++) {
                        if (parent instanceof RelativeLayout) {
                            this.a.m0((RelativeLayout) parent);
                            return true;
                        }
                        parent = parent.getParent();
                    }
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23224e;

        public f(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23224e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23224e.mCommentView.performClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f23226f;

        public g(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23226f = bVar;
            this.f23225e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23226f.u == null || (pbCommenFloorItemViewHolder = this.f23225e) == null || (agreeView = pbCommenFloorItemViewHolder.mPbRightTopAgreeView) == null || agreeView.getData() == null) {
                return;
            }
            this.f23225e.mPbRightTopAgreeView.getImgAgree();
            String Q = this.f23226f.u.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f23226f.u.Q())) && this.f23226f.u.O() != null) {
                Q = this.f23226f.u.O().H0();
            }
            TiebaStatic.log(new StatisticItem("c14442").param("tid", Q).param("fname", this.f23226f.u.n()).param("fid", this.f23226f.u.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f23225e.mPbRightTopAgreeView.getData().postId));
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f23228f;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f23229e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f23230f;

            public a(h hVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23230f = hVar;
                this.f23229e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.b bVar = this.f23230f.f23228f.z.f23502b;
                    h hVar = this.f23230f;
                    bVar.a(hVar.f23228f.u, null, this.f23229e, hVar.f23227e.mRichTextView.getLayoutStrategy());
                }
            }
        }

        public h(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23228f = bVar;
            this.f23227e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f23227e.pbItemViewRoot == null || this.f23228f.z == null) {
                    return;
                }
                c.a.d.f.m.e.a().postDelayed(new a(this, postData), 100L);
                String Q = this.f23228f.u.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.f23228f.u.Q())) && this.f23228f.u.O() != null) {
                    Q = this.f23228f.u.O().H0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f23228f.u.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.G()).param("obj_source", this.f23228f.E0(view)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f23232f;

        public i(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23232f = bVar;
            this.f23231e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23232f.u == null || (pbCommenFloorItemViewHolder = this.f23231e) == null || (agreeView = pbCommenFloorItemViewHolder.mPbFloorPraiseView) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f23231e.mPbFloorPraiseView.getImgAgree() ? 1 : 2;
            String Q = this.f23232f.u.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f23232f.u.Q())) && this.f23232f.u.O() != null) {
                Q = this.f23232f.u.O().H0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f23232f.u.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f23231e.mPbFloorPraiseView.getData().postId).param("obj_source", this.f23232f.E0(this.f23231e.mPbFloorPraiseView)).param("obj_type", i2));
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f23234f;

        public j(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23234f = bVar;
            this.f23233e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f23234f.u == null || (pbCommenFloorItemViewHolder = this.f23233e) == null || (agreeView = pbCommenFloorItemViewHolder.mPbRightTopAgreeView) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f23233e.mPbRightTopAgreeView.getImgAgree() ? 1 : 2;
            String Q = this.f23234f.u.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.f23234f.u.Q())) && this.f23234f.u.O() != null) {
                Q = this.f23234f.u.O().H0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.f23234f.u.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f23233e.mPbRightTopAgreeView.getData().postId).param("obj_source", this.f23234f.E0(this.f23233e.mPbRightTopAgreeView)).param("obj_type", i2));
            TiebaStatic.log(new StatisticItem("c14440").param("tid", Q).param("fname", this.f23234f.u.n()).param("fid", this.f23234f.u.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f23233e.mPbRightTopAgreeView.getData().postId));
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f23235e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f23236f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f23237g;

        public k(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23237g = bVar;
            this.f23235e = pbCommenFloorItemViewHolder;
            this.f23236f = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = this.f23235e.mAllContent.getVisibility() == 8;
                this.f23237g.k0(this.f23235e, !z, this.f23236f.D());
                this.f23236f.s0(!z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 0;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = new SparseIntArray();
        this.x = null;
        this.B = new c.a.d.f.k.b<>(new c(this), 6, 0);
        this.C = new c.a.d.f.k.b<>(new d(this), 12, 0);
        this.D = new c.a.r0.u2.i.c(new e(this));
        this.n = tbPageContext;
        this.m = C0(R.dimen.tbds14);
    }

    public final void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.updateUegInfo(postData.U, postData.G(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x0671  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0781  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.t() != null) {
            postData.t().isBaijiahaoUser();
        }
        if (postData.T) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.mTopLine, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.mTopLine.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.mTopLine.setVisibility(8);
        }
        e2 e2Var = null;
        pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(null);
        pbCommenFloorItemViewHolder.mHeadPhotoView.setUserId(null);
        pbCommenFloorItemViewHolder.mUserNameView.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.mRichTextView.setIsHost(false);
        if (postData.t() != null) {
            String str = this.t;
            if (str != null && !str.equals("0") && this.t.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.mRichTextView.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.mTshowIconBox;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.t().getUserId());
                c.a.r0.u2.k.f.e1.a aVar = this.y;
                if (aVar != null) {
                    pbCommenFloorItemViewHolder.mTshowIconBox.setOnClickListener(aVar.f23481c);
                }
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.mTshowIconBox;
                i3 = R.id.tag_user_id;
                userIconBox2.loadIcon(iconInfo, 2, f2, f2, f3);
            } else {
                i3 = R.id.tag_user_id;
            }
            if (pbCommenFloorItemViewHolder.mVipIconBox != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.mVipIconBox.setTag(tShowInfoNew.get(0).getUrl());
                }
                c.a.r0.u2.k.f.e1.a aVar2 = this.y;
                if (aVar2 != null) {
                    pbCommenFloorItemViewHolder.mVipIconBox.setOnClickListener(aVar2.f23482d);
                }
                int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.mVipIconBox.loadIcon(tShowInfoNew, 3, f4, f4, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        s0.k(pbCommenFloorItemViewHolder.mUserNameView);
                    } else {
                        c.a.q0.r.v.c.d(pbCommenFloorItemViewHolder.mUserNameView).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            int i4 = postData.e0 ? 2 : 8;
            pbCommenFloorItemViewHolder.mUserNameView.setTag(i3, postData.t().getUserId());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_statistic_item, c.a.r0.u2.m.a.i(this.u, postData, postData.f0, i4, 2));
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.mUserNameView.setText(c.a.r0.u2.c.b(this.f3076e, pbCommenFloorItemViewHolder.mUserNameView.getText().toString()));
                pbCommenFloorItemViewHolder.mUserNameView.setGravity(16);
                pbCommenFloorItemViewHolder.mUserNameView.setTag(R.id.tag_nick_name_activity, c.a.r0.u2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.mPendantHeadView.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.mPendantHeadView.showHeadPendantAndBigV(postData.t(), 4);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setVisibility(8);
                pbCommenFloorItemViewHolder.mPendantHeadView.setVisibility(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setUserName(postData.t().getUserName());
                c.a.r0.u2.h.f fVar = this.u;
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setFid(fVar != null ? fVar.m() : "");
                c.a.r0.u2.h.f fVar2 = this.u;
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setFName(fVar2 != null ? fVar2.n() : "");
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setFloor(postData.A());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setTid(postData.G());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setTag(R.id.tag_statistic_item, c.a.r0.u2.m.a.i(this.u, postData, postData.f0, i4, 2));
                pbCommenFloorItemViewHolder.mPendantHeadView.startLoadPendantUrl(postData.t().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.mHeadPhotoView.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.mHeadPhotoView, postData.t(), 4);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setUserId(postData.t().getUserId());
                c.a.r0.u2.h.f fVar3 = this.u;
                pbCommenFloorItemViewHolder.mHeadPhotoView.setFid(fVar3 != null ? fVar3.m() : "");
                c.a.r0.u2.h.f fVar4 = this.u;
                pbCommenFloorItemViewHolder.mHeadPhotoView.setFName(fVar4 != null ? fVar4.n() : "");
                pbCommenFloorItemViewHolder.mHeadPhotoView.setFloor(postData.A());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTid(postData.G());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setUserName(postData.t().getUserName(), postData.X());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.mHeadPhotoView.setTag(R.id.tag_statistic_item, c.a.r0.u2.m.a.i(this.u, postData, postData.f0, i4, 2));
                pbCommenFloorItemViewHolder.mHeadPhotoView.setImageDrawable(null);
                pbCommenFloorItemViewHolder.mHeadPhotoView.startLoad(avater, 28, false);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setVisibility(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.setVisibility(8);
            }
            if (postData.t() != null && postData.t().getAlaInfo() != null && postData.t().getAlaUserData() != null && postData.t().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.handleUserAlaLiveState(true);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setLiveStatus(1);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setAlaInfo(postData.t().getAlaInfo());
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setAlaInfo(postData.t().getAlaInfo());
                e2Var = null;
            } else {
                pbCommenFloorItemViewHolder.handleUserAlaLiveState(false);
                pbCommenFloorItemViewHolder.mHeadPhotoView.setLiveStatus(0);
                e2Var = null;
                pbCommenFloorItemViewHolder.mHeadPhotoView.setAlaInfo(null);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setAlaInfo(null);
            }
            P0(pbCommenFloorItemViewHolder.mFloorAuthorView, postData);
        }
        int level_id = postData.t().getLevel_id();
        c.a.r0.u2.h.f fVar5 = this.u;
        if (fVar5 != null && fVar5.g0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.mForumLevelIcon, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(8);
        }
        int i5 = 15;
        if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() == 1) {
            i5 = 13;
        } else if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.mFloorAuthorView.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.mVipIconBox.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.w() > 1000) {
            i5 -= 2;
        }
        if (postData.w() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            pbCommenFloorItemViewHolder.mTshowIconBox.setVisibility(8);
            if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() == 1) {
                i5 += 2;
            } else if (pbCommenFloorItemViewHolder.mTshowIconBox.getChildCount() > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.mFloorAuthorView.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.mFloorAuthorView.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.mForumLevelIcon.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.mForumLevelIcon.setVisibility(8);
            }
        }
        int e2 = s0.e();
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = o0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                name_show2 = o0.n(name_show2, i6) + "...";
            }
        } else if (d2 > e2) {
            name_show2 = o0.n(name_show2, e2) + "...";
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.mUserNameView.setText(D0(postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.mUserNameView.setText(name_show2);
            pbCommenFloorItemViewHolder.ownerInfoRootView.post(new a(this, pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.G());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.mPbFloorPraiseView);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.mPbRightTopAgreeView);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.mCommentView);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.mShareView);
        c.a.r0.u2.h.f fVar6 = this.u;
        if (fVar6 != null && fVar6.O() != null) {
            e2Var = this.u.O();
        }
        if (e2Var != null && e2Var.H2()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z7 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        c.a.r0.u2.h.f fVar7 = this.u;
        if (fVar7 == null || fVar7.V() == 0 || F0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.u.V() == 1002 || this.u.V() == 3) ? false : true;
            z2 = (this.u.V() == 3 || this.u.g0()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        c.a.r0.u2.h.f fVar8 = this.u;
        if (fVar8 != null && fVar8.O() != null && this.u.O().J() != null && postData.t() != null) {
            String userId2 = this.u.O().J().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = false;
                    z5 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                z3 = true;
                z6 = true;
                if (postData != null && postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                    z5 = true;
                    z3 = true;
                }
                if (z7) {
                    z = false;
                    z4 = false;
                    z3 = false;
                }
                int i7 = postData.A() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.u.V()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    if (this.u.O() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.u.O().h0());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.G());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.b0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.u.V()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i7));
                    sparseArray.put(R.id.tag_del_post_id, postData.G());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z6));
                pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
            }
        }
        z3 = z2;
        z4 = false;
        z5 = false;
        z6 = false;
        if (postData != null) {
            z5 = true;
            z3 = true;
        }
        if (z7) {
        }
        if (postData.A() != 1) {
        }
        if (!z) {
        }
        if (!z4) {
        }
        if (!z3) {
        }
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z6));
        pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
    }

    public int C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = this.w.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            this.w.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public final SpannableStringBuilder D0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.h(this.f3076e, str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String E0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.pb_track_more_obj_source);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.pb_track_more_obj_source);
            view.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.u2.h.f fVar = this.u;
            if (fVar == null || fVar.O() == null) {
                return false;
            }
            return this.u.O().W1();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: G0 */
    public PbCommenFloorItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f3076e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.n, inflate, 0);
            pbCommenFloorItemViewHolder.mImagesView.setConstrainLayoutPool(this.B);
            pbCommenFloorItemViewHolder.mImagesView.setImageViewPool(this.C);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.mReplyContentView;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.mReplyContentView.setIsVideoThread(false);
            }
            N0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View H0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            N0(pbCommenFloorItemViewHolder);
            I0(pbCommenFloorItemViewHolder);
            i0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.f0 = i2 + 1;
                postData2.I0();
                n0(postData2);
                s0(pbCommenFloorItemViewHolder, postData2, view, i2);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void I0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.pbItemViewRoot.setOnTouchListener(this.D);
            pbCommenFloorItemViewHolder.pbItemViewRoot.setOnLongClickListener(this.s);
            pbCommenFloorItemViewHolder.mUserNameView.setOnClickListener(this.y.f23480b);
            pbCommenFloorItemViewHolder.mHeadPhotoView.setOnClickListener(this.y.f23480b);
            pbCommenFloorItemViewHolder.mPendantHeadView.setOnClickListener(this.y.f23480b);
            pbCommenFloorItemViewHolder.mPendantHeadView.getHeadView().setOnClickListener(this.y.f23480b);
            pbCommenFloorItemViewHolder.mRichTextView.setOnLongClickListener(this.s);
            pbCommenFloorItemViewHolder.mRichTextView.setOnTouchListener(this.D);
            pbCommenFloorItemViewHolder.mRichTextView.setCommonTextViewOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mRichTextView.setOnImageClickListener(this.q);
            pbCommenFloorItemViewHolder.mRichTextView.setOnImageTouchListener(this.D);
            pbCommenFloorItemViewHolder.mRichTextView.setOnEmotionClickListener(this.y.f23483e);
            pbCommenFloorItemViewHolder.mRichTextView.setOnVoiceAfterClickListener(this.p);
            pbCommenFloorItemViewHolder.mTailContent.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mReplyCountView.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mReplyView.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mPbRightTopMoreView.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mBtnOpMore.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mPbPostReplyLayoutAbove.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.pbItemViewRoot.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.mCommentView.setOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mShareView.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.mAfterManualClickListener = new i(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.mPbRightTopAgreeView.mAfterManualClickListener = new j(this, pbCommenFloorItemViewHolder);
        }
    }

    public void J0(c.a.r0.u2.k.f.e1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.y = aVar;
        }
    }

    public void K0(c.a.r0.u2.k.f.e1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.z = cVar;
        }
    }

    public void L0(c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public void M0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, sVar) == null) {
            this.A = sVar;
        }
    }

    public final void N0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.mSkinType != skinType) {
            O0(pbCommenFloorItemViewHolder.mFloorAuthorView);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    s0.k(pbCommenFloorItemViewHolder.mUserNameView);
                } else {
                    c.a.q0.r.v.c.d(pbCommenFloorItemViewHolder.mUserNameView).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mUserNameView, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyTimeView, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mPointRightFloor, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mPointRightPostTime, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mFloorNum, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mLocationView, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyView, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.mRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mViewPostTimeAbove, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mBtnPostAbove, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.mReplyContentView, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyCountView, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mReplyCountView, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.mReplyCountView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mCommentView, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mShareView, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.mReplyContentView.onChangeSkinType();
            pbCommenFloorItemViewHolder.mImagesView.onChangeSkinType();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mRecommendLiveTitleView, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mRecommendLivePrefixTv, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.mRecommendLiveLayout, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.mRecommendLiveDividerView, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.mRecommendLiveArrowView, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.mFoldTitleView, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.mAllContent.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.mFoldTitleView.setText(R.string.close_content);
            } else {
                c.a.r0.u2.h.f fVar = this.u;
                if (fVar != null && StringUtils.isNull(fVar.k())) {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(this.u.k());
                } else {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(R.string.expand_content);
                }
            }
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.handleUserAlaLiveSkinType(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.mBottomLine, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mPbRightTopMoreView, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.mBtnOpMore, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.handleUegSkin();
        }
        pbCommenFloorItemViewHolder.mSkinType = skinType;
    }

    public final void O0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            P0(textView, (PostData) tag);
        }
    }

    public final void P0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.t;
                if (str != null && !str.equals("0") && this.t.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                    return;
                } else if (t.getIs_bawu() == 1 && postData.c0()) {
                    c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                    return;
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    c.a.q0.r.v.c d5 = c.a.q0.r.v.c.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                    return;
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    c.a.q0.r.v.c d6 = c.a.q0.r.v.c.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                    return;
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    c.a.q0.r.v.c d7 = c.a.q0.r.v.c.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                    return;
                } else {
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        H0(i2, view, viewGroup, postData, pbCommenFloorItemViewHolder);
        return view;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            this.s = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewOnTouchListener(this.r);
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewCheckSelection(false);
        }
    }

    public final void j0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048597, this, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k2 = (((n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int C0 = z ? C0(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - C0) * 1.0f));
        tbRichTextView.getLayoutStrategy().G = (k2 - C0) - C0(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * 1.0f));
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.mAllContent.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(R.string.expand_content);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.mFoldTitleView.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.mAllContent.setVisibility(0);
            pbCommenFloorItemViewHolder.mFoldTitleView.setText(R.string.close_content);
        }
    }

    public final void l0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.mBottomLine) == null || pbCommenFloorItemViewHolder.mFoldOpArea == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.mFoldOpArea.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.P());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mBottomLine.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.mFoldOpArea.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().l(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().l(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.mFoldOpArea.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = n.f(this.f3076e, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().l(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().m(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = n.f(this.f3076e, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.mBottomLine.setLayoutParams(layoutParams);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public final void m0(View view) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, view) == null) || view == null || !(view.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag()).mPbRightTopAgreeView) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mPbRightTopAgreeView.onAgreeClick();
    }

    public final void n0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = c.a.r0.u2.m.a.i(this.u, postData, postData.f0, postData.e0 ? 2 : 8, 6);
        postData.g0 = i2;
        if (ListUtils.isEmpty(postData.P())) {
            return;
        }
        Iterator<PostData> it = postData.P().iterator();
        while (it.hasNext()) {
            it.next().g0 = i2;
        }
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (TextUtils.isEmpty(postData.u())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.mRichTextView.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.mRichTextView.startLoad(null);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
                layoutParams2.topMargin = C0(R.dimen.ds20);
                layoutParams2.bottomMargin = C0(R.dimen.ds20);
                pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.mRichTextView.startLoad(postData.u());
            }
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewOnTouchListener(this.D);
            pbCommenFloorItemViewHolder.mRichTextView.setTextViewCheckSelection(false);
        }
    }

    public void p(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, yVar) == null) {
            this.q = yVar;
        }
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.mFeedBackImg) == null || this.u == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.t = str;
        }
    }

    public final void q0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        int i3;
        c.a.r0.u2.h.f fVar;
        c.a.r0.u2.h.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && (fVar2 = this.u) != null && !fVar2.g0()) {
            String format = String.format(this.f3076e.getString(R.string.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.mFloorNum.setVisibility(0);
            pbCommenFloorItemViewHolder.mFloorNum.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.mFloorNum.setVisibility(8);
            z = false;
        }
        c.a.q0.t.g K = postData.K();
        z2 = (K == null || StringUtils.isNull(K.b()) || (fVar = this.u) == null || fVar.g0()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.mPointRightFloor.setVisibility(0);
            i2 = this.m;
        } else {
            pbCommenFloorItemViewHolder.mPointRightFloor.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.mPointRightPostTime.setVisibility(0);
            i3 = this.m;
        } else {
            pbCommenFloorItemViewHolder.mPointRightPostTime.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.mReplyTimeView.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.V()), "yyyy"))) {
            pbCommenFloorItemViewHolder.mReplyTimeView.setText(StringHelper.getFormatTimeShort(postData.V()));
        } else {
            pbCommenFloorItemViewHolder.mReplyTimeView.setText(StringHelper.getFormatTime(postData.V()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.mLocationView.setVisibility(0);
            pbCommenFloorItemViewHolder.mLocationView.setPadding(this.m, 0, 0, 0);
            if (postData.d0) {
                pbCommenFloorItemViewHolder.mLocationView.setText(StringHelper.cutStringWithSuffix(K.b(), 7, "..."));
            } else {
                pbCommenFloorItemViewHolder.mLocationView.setText(K.b());
            }
        } else {
            pbCommenFloorItemViewHolder.mLocationView.setVisibility(8);
        }
        TextView textView = pbCommenFloorItemViewHolder.mViewPostTimeAbove;
        textView.setText(((Object) pbCommenFloorItemViewHolder.mReplyTimeView.getText()) + "  • ");
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mImgGodComment.setVisibility(postData.d0 ? 0 : 8);
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048609, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.mTrisectionContainer.setVisibility(8);
        pbCommenFloorItemViewHolder.mPbRightTopLayout.setVisibility(0);
        pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(0);
        pbCommenFloorItemViewHolder.mPbPostReplyLayoutAbove.setVisibility(8);
        pbCommenFloorItemViewHolder.mCommentView.setVisibility(8);
        pbCommenFloorItemViewHolder.mShareView.setVisibility(8);
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setVisibility(8);
        pbCommenFloorItemViewHolder.mBtnOpMore.setVisibility(8);
        B0(pbCommenFloorItemViewHolder, postData, view, i2);
        p0(pbCommenFloorItemViewHolder, postData);
        t0(pbCommenFloorItemViewHolder, postData);
        w0(pbCommenFloorItemViewHolder, postData, view);
        v0(pbCommenFloorItemViewHolder, postData, view, i2);
        q0(pbCommenFloorItemViewHolder, postData);
        y0(pbCommenFloorItemViewHolder, postData);
        u0(pbCommenFloorItemViewHolder, postData);
        z0(pbCommenFloorItemViewHolder, postData);
        o0(pbCommenFloorItemViewHolder, postData);
        r0(pbCommenFloorItemViewHolder, postData);
        x0(pbCommenFloorItemViewHolder, postData);
        A0(pbCommenFloorItemViewHolder, postData);
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.v = z;
        }
    }

    public void t(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public final void t0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().objType = 1;
        postData.q().isInPost = true;
        e2 e2Var = null;
        c.a.r0.u2.h.f fVar = this.u;
        if (fVar != null && fVar.O() != null) {
            e2Var = this.u.O();
            postData.q().threadId = e2Var.w1();
            postData.q().forumId = String.valueOf(e2Var.U());
        }
        if (e2Var != null && e2Var.H2()) {
            pbCommenFloorItemViewHolder.mPbFloorPraiseView.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setThreadData(e2Var);
        pbCommenFloorItemViewHolder.mPbFloorPraiseView.setData(postData.q());
        pbCommenFloorItemViewHolder.mPbRightTopAgreeView.setThreadData(e2Var);
        pbCommenFloorItemViewHolder.mPbRightTopAgreeView.setData(postData.q());
    }

    public final void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048613, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.mRecommendLiveTitleView == null || pbCommenFloorItemViewHolder.mRecommendLiveLayout == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.V) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.mRecommendLiveTitleView.setText(postData.V.liveTitle);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setTag(postData.V);
            pbCommenFloorItemViewHolder.mRecommendLiveLayout.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.mRecommendLiveLayout.setVisibility(8);
    }

    public final void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048614, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.R() > 0) {
            pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.mReplyView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.mReplyView.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, postData);
            if (postData.E() == 2) {
                pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.mReplyView.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.mReplyCountView.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.mCommentView;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.mCommentView.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, postData);
        }
        if (this.u != null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.u.m());
            statisticItem.param("fname", this.u.n());
            statisticItem.param("tid", this.u.Q());
            statisticItem.param("pid", postData.G());
            TiebaStatic.log(statisticItem);
        }
        if (pbCommenFloorItemViewHolder.mPbFloorComplaint != null) {
            PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view.findViewById(R.id.pb_floor_complaint);
            pbCommenFloorItemViewHolder.mPbFloorComplaint = pbFloorComplaint;
            pbCommenFloorItemViewHolder.mIsShowFlooorComplaint = Boolean.TRUE;
            pbFloorComplaint.setRemindText(postData.C());
            pbCommenFloorItemViewHolder.mPbFloorComplaint.setRemindIcon(postData.C());
            if (postData.C() == 0) {
                pbCommenFloorItemViewHolder.mPbFloorComplaint.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.mPbFloorComplaint.setVisibility(0);
                if (this.u != null) {
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", this.u.m());
                    statisticItem2.param("fname", this.u.n());
                    statisticItem2.param("tid", this.u.Q());
                    statisticItem2.param("pid", postData.G());
                    statisticItem2.param("obj_type", postData.C());
                    TiebaStatic.log(statisticItem2);
                }
            }
            pbCommenFloorItemViewHolder.mPbFloorComplaint.setAmendIconListener(new View$OnClickListenerC1442b(this, postData.B(), postData));
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.mShareView;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.mShareView.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        pbCommenFloorItemViewHolder.mReplyCountView.setVisibility(8);
        if (!postData.b0() && !postData.a0(false)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mReplyContentView.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.mReplyContentView.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.mReplyContentView.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mReplyContentView.getLayoutParams();
            layoutParams2.topMargin = n.f(this.f3076e, R.dimen.tbds10);
            layoutParams2.leftMargin = n.f(this.f3076e, R.dimen.tbds148);
            layoutParams2.rightMargin = n.f(this.f3076e, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = n.f(this.f3076e, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.mReplyContentView.setLayoutParams(layoutParams2);
            if (this.x == null) {
                c.a.r0.u2.k.h.b bVar = new c.a.r0.u2.k.h.b(this.f3076e);
                this.x = bVar;
                bVar.f(this.v);
                this.x.h(this.o);
                this.x.e(this.p);
                String str = null;
                c.a.r0.u2.h.f fVar = this.u;
                if (fVar != null && fVar.O() != null && this.u.O().J() != null) {
                    str = this.u.O().J().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                c.a.r0.u2.h.f fVar2 = this.u;
                if (fVar2 != null) {
                    this.x.j(fVar2.V(), z);
                    this.x.i(this.u.O());
                }
            }
            this.x.g(postData.G());
            pbCommenFloorItemViewHolder.mReplyContentView.setSubPbAdapter(this.x);
            pbCommenFloorItemViewHolder.mReplyContentView.setVisibility(0);
            pbCommenFloorItemViewHolder.mReplyContentView.setData(postData, view);
            pbCommenFloorItemViewHolder.mReplyContentView.setChildOnClickListener(this.p);
            pbCommenFloorItemViewHolder.mReplyContentView.setChildOnLongClickListener(this.s);
            pbCommenFloorItemViewHolder.mReplyContentView.setChildOnTouchListener(this.D);
        }
        if (postData.R) {
            pbCommenFloorItemViewHolder.mBottomLine.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.mBottomLine.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.mReplyView.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mPostReplyContainer.getLayoutParams();
        layoutParams3.topMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.mReplyCountView.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.mPostReplyContainer.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.mBtnPostAbove.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048615, this, pbCommenFloorItemViewHolder, postData, view) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.mRichTextView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = n.f(this.f3076e, R.dimen.M_W_X007);
        layoutParams.leftMargin = n.f(this.f3076e, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.mRichTextView.setPadding(0, 0, 0, 0);
        pbCommenFloorItemViewHolder.mRichTextView.startLoad(null);
        pbCommenFloorItemViewHolder.mRichTextView.setBackgroundDrawable(null);
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().g(R.drawable.transparent_bg);
        pbCommenFloorItemViewHolder.mRichTextView.getLayoutStrategy().x(R.drawable.pic_video);
        j0(pbCommenFloorItemViewHolder.mRichTextView, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.mRichTextView.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.mRichTextView.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.mRichTextView.setIsFromCDN(this.v);
        pbCommenFloorItemViewHolder.mRichTextView.setText(postData.N(), true, this.A);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.mRichTextView.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbCommenFloorItemViewHolder.mRichTextView.setTag(sparseArray);
        pbCommenFloorItemViewHolder.pbItemViewRoot.setTag(R.id.tag_from, sparseArray);
        pbCommenFloorItemViewHolder.mBtnOpMore.setTag(sparseArray);
        pbCommenFloorItemViewHolder.mPbRightTopMoreView.setTag(sparseArray);
    }

    public final void x0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.pbItemViewRoot) == null) {
            return;
        }
        SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
    }

    public final void y0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.S() != null) {
                TbRichText N = postData.N();
                c.a.r0.u2.p.h.c(postData.S(), pbCommenFloorItemViewHolder.mTailContent, false, false, N != null && StringUtils.isNull(N.toString()) && StringUtils.isNull(postData.u()));
                return;
            }
            pbCommenFloorItemViewHolder.mTailContent.setVisibility(8);
        }
    }

    public final void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.E() != 2 && postData.E() != 4) {
                pbCommenFloorItemViewHolder.mFoldOpArea.setVisibility(8);
                pbCommenFloorItemViewHolder.mAllContent.setVisibility(0);
                l0(false, pbCommenFloorItemViewHolder, postData);
                return;
            }
            pbCommenFloorItemViewHolder.mFoldOpArea.setOnClickListener(new k(this, pbCommenFloorItemViewHolder, postData));
            pbCommenFloorItemViewHolder.mFoldOpArea.setVisibility(0);
            k0(pbCommenFloorItemViewHolder, postData.d0(), postData.D());
            l0(true, pbCommenFloorItemViewHolder, postData);
        }
    }
}
