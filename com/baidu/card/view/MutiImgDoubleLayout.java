package com.baidu.card.view;

import android.content.Context;
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
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.en;
import com.baidu.tieba.go6;
import com.baidu.tieba.h15;
import com.baidu.tieba.l06;
import com.baidu.tieba.n05;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgDoubleLayout extends LinearLayout implements oy<h15> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public PlayVoiceBntNew c;
    public RelativeLayout d;
    public TbImageView e;
    public TbImageView f;
    public String g;
    public boolean h;
    public go6<h15> i;
    public h15 j;
    public int k;
    public l06 l;
    public LinkedList<MediaData> m;

    public void setPreloadSizeReadyCallback(en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, enVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgDoubleLayout a;

        public a(MutiImgDoubleLayout mutiImgDoubleLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgDoubleLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgDoubleLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            go6<h15> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements l06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MutiImgDoubleLayout a;

        public b(MutiImgDoubleLayout mutiImgDoubleLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgDoubleLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mutiImgDoubleLayout;
        }

        @Override // com.baidu.tieba.l06
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                go6<h15> subClickListener = this.a.getSubClickListener();
                if (subClickListener != null) {
                    view2.setTag("1");
                    this.a.j.objType = 2;
                    subClickListener.a(view2, this.a.j);
                    this.a.j.objType = 1;
                }
                ThreadCardUtils.startImageViewer(view2, this.a.h, this.a.m, i, this.a.j.getThreadData(), this.a.g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public boolean c;
        public final /* synthetic */ MutiImgDoubleLayout d;

        public c(MutiImgDoubleLayout mutiImgDoubleLayout, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutiImgDoubleLayout, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mutiImgDoubleLayout;
            a(i, z, z2);
        }

        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a = i;
                this.b = z;
                this.c = z2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || this.d.l == null) {
                return;
            }
            l06 l06Var = this.d.l;
            int i = this.a;
            if (this.b && this.c) {
                z = true;
            } else {
                z = false;
            }
            l06Var.a(view2, i, z);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(668624915, "Lcom/baidu/card/view/MutiImgDoubleLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(668624915, "Lcom/baidu/card/view/MutiImgDoubleLayout;");
                return;
            }
        }
        vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        n = vi.l(TbadkCoreApplication.getInst()) - ((vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutiImgDoubleLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = true;
        this.j = null;
        this.k = 0;
        h();
    }

    public final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int i2 = this.k;
            if (i2 > 0) {
                return i2;
            }
            int size = (View.MeasureSpec.getSize(i) - (2 * TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10))) / 3;
            this.k = size;
            return size;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oy
    /* renamed from: i */
    public void a(h15 h15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h15Var) == null) {
            this.j = h15Var;
            ThreadData threadData = h15Var.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData);
            ThreadCardUtils.setAbstract(this.b, this.a, threadData, n);
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.g = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.h = z;
        }
    }

    public void setSubClickListener(go6<h15> go6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, go6Var) == null) {
            this.i = go6Var;
        }
    }

    private void setImageData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            if (n05.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList<MediaData> linkedList = new LinkedList<>();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                this.m = linkedList;
                this.d.setVisibility(8);
                if (ListUtils.getCount(linkedList) == 2) {
                    this.d.setVisibility(0);
                    this.e.setConrers(15);
                    k((MediaData) ListUtils.getItem(medias, 0), this.e, true, false, false, 0);
                    this.f.setConrers(15);
                    k((MediaData) ListUtils.getItem(medias, 1), this.f, true, false, true, 1);
                    return;
                }
                this.d.setVisibility(8);
                return;
            }
            this.d.setVisibility(8);
        }
    }

    private void setVoiceData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, threadData) == null) {
            ArrayList<VoiceData.VoiceModel> voice = threadData.getVoice();
            if (ListUtils.isEmpty(voice)) {
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voice.get(0);
            this.c.setVoiceModel(voiceModel);
            this.c.setTag(voiceModel);
            this.c.e();
            if (voiceModel != null) {
                this.c.m(voiceModel.voice_status.intValue());
            }
            this.c.o();
        }
    }

    public go6<h15> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (go6) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.thread_card_abstract);
            this.a = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            HomeGroupUbsUIHelper.handleContentInterval(this.c, R.dimen.tbds28, R.dimen.tbds14);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.a, R.dimen.tbds7, R.dimen.tbds10);
            HomeGroupUbsUIHelper.handleTextLineSpacingExtra(this.b, R.dimen.tbds7, R.dimen.tbds10);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
            this.d = relativeLayout;
            HomeGroupUbsUIHelper.handleContentInterval(relativeLayout, R.dimen.tbds20, R.dimen.tbds14);
            this.e = (TbImageView) findViewById(R.id.thread_card_img_double_one);
            this.f = (TbImageView) findViewById(R.id.thread_card_img_double_two);
            this.l = new b(this);
        }
    }

    public final void j(TbImageView tbImageView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{tbImageView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.l != null && tbImageView != null) {
                View.OnClickListener onClickListener = tbImageView.getOnClickListener();
                if (onClickListener instanceof c) {
                    ((c) onClickListener).a(i, z, z2);
                } else {
                    tbImageView.setOnClickListener(new c(this, i, z, z2));
                }
            } else if (this.l == null && tbImageView != null) {
                tbImageView.setClickable(false);
            }
        }
    }

    public final void k(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{mediaData, tbImageView, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)}) == null) {
            String thumbnailsUrl = ThreadCardUtils.getThumbnailsUrl(mediaData);
            if (this.h) {
                i2 = 13;
            } else {
                i2 = 14;
            }
            if (!StringHelper.equals(thumbnailsUrl, tbImageView.getUrl())) {
                tbImageView.H();
            }
            if (z) {
                tbImageView.setRadius(vi.g(getContext(), R.dimen.tbds10));
                tbImageView.setDrawBorder(true);
                tbImageView.setForegroundColor(0);
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
            }
            tbImageView.N(thumbnailsUrl, i2, false);
            j(tbImageView, i, z2, z3);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int g = g(i);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = g;
            layoutParams.height = g;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.width = g;
            layoutParams2.height = g;
            if (this.d.getVisibility() != 8) {
                this.e.setLayoutParams(layoutParams);
                this.f.setLayoutParams(layoutParams2);
            }
        }
    }

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
