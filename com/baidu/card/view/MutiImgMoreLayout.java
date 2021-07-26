package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.k.p;
import d.a.p0.d1.j.d;
import d.a.p0.s.k;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<d.a.p0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4525e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f4526f;

    /* renamed from: g  reason: collision with root package name */
    public PlayVoiceBntNew f4527g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f4528h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4529i;
    public TbImageView j;
    public TbImageView k;
    public String l;
    public boolean m;
    public b0<d.a.p0.s.q.a> n;
    public d.a.p0.s.q.a o;
    public int p;
    public d q;
    public LinkedList<MediaData> r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgMoreLayout f4530e;

        public a(MutiImgMoreLayout mutiImgMoreLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMoreLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4530e = mutiImgMoreLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b0<d.a.p0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f4530e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f4530e.o);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgMoreLayout f4531a;

        public b(MutiImgMoreLayout mutiImgMoreLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMoreLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4531a = mutiImgMoreLayout;
        }

        @Override // d.a.p0.d1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                b0<d.a.p0.s.q.a> subClickListener = this.f4531a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.f4531a.o.objType = 2;
                    subClickListener.a(view, this.f4531a.o);
                    this.f4531a.o.objType = 1;
                }
                ThreadCardUtils.startImageViewer(view, this.f4531a.m, this.f4531a.r, i2, this.f4531a.o.getThreadData(), this.f4531a.l);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f4532e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4533f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4534g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutiImgMoreLayout f4535h;

        public c(MutiImgMoreLayout mutiImgMoreLayout, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgMoreLayout, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4535h = mutiImgMoreLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f4532e = i2;
                this.f4533f = z;
                this.f4534g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f4535h.q == null) {
                return;
            }
            this.f4535h.q.a(view, this.f4532e, this.f4533f && this.f4534g);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1010531121, "Lcom/baidu/card/view/MutiImgMoreLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1010531121, "Lcom/baidu/card/view/MutiImgMoreLayout;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        s = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgMoreLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setImageData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, b2Var) == null) {
            ArrayList<MediaData> A0 = b2Var.A0();
            if (k.c().g() && ListUtils.getCount(A0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < A0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(A0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.r = linkedList;
                boolean z = linkedList.size() > 3;
                this.f4528h.setVisibility(8);
                if (ListUtils.getCount(linkedList) >= 3) {
                    this.f4528h.setVisibility(0);
                    this.f4529i.setConrers(15);
                    l((MediaData) ListUtils.getItem(A0, 0), this.f4529i, R.string.J_X12, false, false, 0);
                    this.j.setConrers(15);
                    l((MediaData) ListUtils.getItem(A0, 1), this.j, R.string.J_X02, false, false, 1);
                    this.k.setConrers(15);
                    l((MediaData) ListUtils.getItem(A0, 2), this.k, R.string.J_X11, z, true, 2);
                    return;
                }
                this.f4528h.setVisibility(8);
                return;
            }
            this.f4528h.setVisibility(8);
        }
    }

    private void setVoiceData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, b2Var) == null) {
            ArrayList<VoiceData$VoiceModel> y1 = b2Var.y1();
            if (ListUtils.isEmpty(y1)) {
                this.f4527g.setVisibility(8);
                return;
            }
            this.f4527g.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = y1.get(0);
            this.f4527g.setVoiceModel(voiceData$VoiceModel);
            this.f4527g.setTag(voiceData$VoiceModel);
            this.f4527g.b();
            if (voiceData$VoiceModel != null) {
                this.f4527g.j(voiceData$VoiceModel.voice_status.intValue());
            }
            this.f4527g.l();
        }
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.p;
            if (i3 > 0) {
                return i3;
            }
            int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
            this.p = size;
            return size;
        }
        return invokeI.intValue;
    }

    public b0<d.a.p0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (b0) invokeV.objValue;
    }

    public final String h(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String picUrl = mediaData.getPicUrl();
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getSmallUrl();
            }
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getThumbnails_url();
            }
            return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
        }
        return (String) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4526f = (TextView) findViewById(R.id.thread_card_abstract);
            this.f4525e = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.f4527g = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.f4528h = relativeLayout;
            d.a.p0.b.g.b.d(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
            this.f4529i = (TbImageView) findViewById(R.id.thread_card_img_more_one);
            this.j = (TbImageView) findViewById(R.id.thread_card_img_more_two);
            this.k = (TbImageView) findViewById(R.id.thread_card_img_more_three);
            this.q = new b(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: j */
    public void a(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.o = aVar;
            b2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.f4525e, threadData);
            ThreadCardUtils.setAbstract(this.f4526f, this.f4525e, threadData, s);
            TextView textView = this.f4525e;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.f4526f;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            RelativeLayout relativeLayout = this.f4528h;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void k(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.q != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof c) {
                    ((c) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new c(this, i2, z, z2));
                }
            } else if (this.q != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void l(MediaData mediaData, TbImageView tbImageView, int i2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{mediaData, tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            String h2 = h(mediaData);
            int i4 = this.m ? 13 : 14;
            if (!StringHelper.equals(h2, tbImageView.getUrl())) {
                tbImageView.I();
            }
            tbImageView.setRadiusById(i2);
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.M(h2, i4, false);
            k(tbImageView, i3, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int g2 = g(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4529i.getLayoutParams();
            layoutParams.width = g2;
            layoutParams.height = g2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams2.width = g2;
            layoutParams2.height = g2;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams3.width = g2;
            layoutParams3.height = g2;
            if (this.f4528h.getVisibility() != 8) {
                this.f4529i.setLayoutParams(layoutParams);
                this.j.setLayoutParams(layoutParams2);
                this.k.setLayoutParams(layoutParams3);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
        }
    }

    public void setMarginsTop(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setPreloadSizeReadyCallback(d.a.d.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<d.a.p0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, b0Var) == null) {
            this.n = b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = true;
        this.o = null;
        this.p = 0;
        i();
    }
}
