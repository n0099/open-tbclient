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
import b.a.e.f.p.l;
import b.a.l.p;
import b.a.q0.e1.j.d;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.r0.b0.d0;
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
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f37575e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37576f;

    /* renamed from: g  reason: collision with root package name */
    public d0<b.a.q0.s.q.a> f37577g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.q.a f37578h;

    /* renamed from: i  reason: collision with root package name */
    public int f37579i;
    public d j;
    public LinkedList<MediaData> k;
    public TextView mAbstract;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;
    public RelativeLayout moreImgContainer;
    public TbImageView moreImgOne;
    public TbImageView moreImgThree;
    public TbImageView moreImgTwo;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutiImgMoreLayout f37580e;

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
            this.f37580e = mutiImgMoreLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0<b.a.q0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f37580e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f37580e.f37578h);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MutiImgMoreLayout f37581a;

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
            this.f37581a = mutiImgMoreLayout;
        }

        @Override // b.a.q0.e1.j.d
        public void a(View view, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                d0<b.a.q0.s.q.a> subClickListener = this.f37581a.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    this.f37581a.f37578h.objType = 2;
                    subClickListener.a(view, this.f37581a.f37578h);
                    this.f37581a.f37578h.objType = 1;
                }
                ThreadCardUtils.startImageViewer(view, this.f37581a.f37576f, this.f37581a.k, i2, this.f37581a.f37578h.getThreadData(), this.f37581a.f37575e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f37582e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37583f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f37584g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MutiImgMoreLayout f37585h;

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
            this.f37585h = mutiImgMoreLayout;
            a(i2, z, z2);
        }

        public void a(int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f37582e = i2;
                this.f37583f = z;
                this.f37584g = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f37585h.j == null) {
                return;
            }
            this.f37585h.j.a(view, this.f37582e, this.f37583f && this.f37584g);
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
        l = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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

    private void setImageData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, d2Var) == null) {
            ArrayList<MediaData> E0 = d2Var.E0();
            if (k.c().g() && ListUtils.getCount(E0) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < E0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(E0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.k = linkedList;
                boolean z = linkedList.size() > 3;
                this.moreImgContainer.setVisibility(8);
                if (ListUtils.getCount(linkedList) >= 3) {
                    this.moreImgContainer.setVisibility(0);
                    this.moreImgOne.setConrers(15);
                    j((MediaData) ListUtils.getItem(E0, 0), this.moreImgOne, R.string.J_X12, false, false, 0);
                    this.moreImgTwo.setConrers(15);
                    j((MediaData) ListUtils.getItem(E0, 1), this.moreImgTwo, R.string.J_X02, false, false, 1);
                    this.moreImgThree.setConrers(15);
                    j((MediaData) ListUtils.getItem(E0, 2), this.moreImgThree, R.string.J_X11, z, true, 2);
                    return;
                }
                this.moreImgContainer.setVisibility(8);
                return;
            }
            this.moreImgContainer.setVisibility(8);
        }
    }

    private void setVoiceData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, d2Var) == null) {
            ArrayList<VoiceData$VoiceModel> E1 = d2Var.E1();
            if (ListUtils.isEmpty(E1)) {
                this.mVoiceBtn.setVisibility(8);
                return;
            }
            this.mVoiceBtn.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = E1.get(0);
            this.mVoiceBtn.setVoiceModel(voiceData$VoiceModel);
            this.mVoiceBtn.setTag(voiceData$VoiceModel);
            this.mVoiceBtn.changeSkin();
            if (voiceData$VoiceModel != null) {
                this.mVoiceBtn.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
            }
            this.mVoiceBtn.resetLayoutParams();
        }
    }

    public final int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.f37579i;
            if (i3 > 0) {
                return i3;
            }
            int size = (View.MeasureSpec.getSize(i2) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
            this.f37579i = size;
            return size;
        }
        return invokeI.intValue;
    }

    public final String g(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaData)) == null) {
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

    public d0<b.a.q0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37577g : (d0) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
            this.moreImgContainer = relativeLayout;
            b.a.q0.b.g.b.d(relativeLayout, R.dimen.tbds26, R.dimen.tbds14);
            this.moreImgOne = (TbImageView) findViewById(R.id.thread_card_img_more_one);
            this.moreImgTwo = (TbImageView) findViewById(R.id.thread_card_img_more_two);
            this.moreImgThree = (TbImageView) findViewById(R.id.thread_card_img_more_three);
            this.j = new b(this);
        }
    }

    public final void i(TbImageView tbImageView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.j != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof c) {
                    ((c) onClickListener).a(i2, z, z2);
                } else {
                    tbImageView.setOnClickListener(new c(this, i2, z, z2));
                }
            } else if (this.j != null || tbImageView == null) {
            } else {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void j(MediaData mediaData, TbImageView tbImageView, int i2, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{mediaData, tbImageView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            String g2 = g(mediaData);
            int i4 = this.f37576f ? 13 : 14;
            if (!StringHelper.equals(g2, tbImageView.getUrl())) {
                tbImageView.reset();
            }
            tbImageView.setRadiusById(i2);
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.startLoad(g2, i4, false);
            i(tbImageView, i3, z, z2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int f2 = f(i2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.moreImgOne.getLayoutParams();
            layoutParams.width = f2;
            layoutParams.height = f2;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.moreImgTwo.getLayoutParams();
            layoutParams2.width = f2;
            layoutParams2.height = f2;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.moreImgThree.getLayoutParams();
            layoutParams3.width = f2;
            layoutParams3.height = f2;
            if (this.moreImgContainer.getVisibility() != 8) {
                this.moreImgOne.setLayoutParams(layoutParams);
                this.moreImgTwo.setLayoutParams(layoutParams2);
                this.moreImgThree.setLayoutParams(layoutParams3);
            }
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f37575e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f37576f = z;
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

    public void setPreloadSizeReadyCallback(b.a.e.m.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
        }
    }

    public void setSubClickListener(d0<b.a.q0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, d0Var) == null) {
            this.f37577g = d0Var;
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
        this.f37576f = true;
        this.f37578h = null;
        this.f37579i = 0;
        h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f37578h = aVar;
            d2 threadData = aVar.getThreadData();
            ThreadCardUtils.setTitle(this.mTitle, threadData);
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, threadData, l);
            TextView textView = this.mTitle;
            boolean z = false;
            boolean z2 = textView == null || textView.getVisibility() != 0;
            TextView textView2 = this.mAbstract;
            boolean z3 = textView2 == null || textView2.getVisibility() != 0;
            RelativeLayout relativeLayout = this.moreImgContainer;
            if (z2 && z3) {
                z = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }
}
