package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hx;
import com.baidu.tieba.ii;
import com.baidu.tieba.jw4;
import com.baidu.tieba.qm;
import com.baidu.tieba.rv4;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tt5;
import com.baidu.tieba.wt5;
import com.baidu.tieba.xf;
import com.baidu.tieba.xg6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class MultiImgLayout extends LinearLayout implements hx<jw4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public PlayVoiceBntNew c;
    public ConstrainImageGroup d;
    public String e;
    public boolean f;
    public xg6<jw4> g;
    public jw4 h;
    public boolean i;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiImgLayout a;

        public a(MultiImgLayout multiImgLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiImgLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            xg6<jw4> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements wt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ MultiImgLayout b;

        public b(MultiImgLayout multiImgLayout, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiImgLayout, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = multiImgLayout;
            this.a = linkedList;
        }

        @Override // com.baidu.tieba.wt5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (this.b.g != null && this.b.g.c(view2, this.b.h, "")) {
                    return;
                }
                xg6<jw4> subClickListener = this.b.getSubClickListener();
                if (subClickListener != null) {
                    view2.setTag("1");
                    this.b.h.objType = 2;
                    subClickListener.a = Boolean.valueOf(z);
                    subClickListener.a(view2, this.b.h);
                    this.b.h.objType = 1;
                }
                if (TbadkCoreApplication.getInst().getAdAdSense() != null && TbadkCoreApplication.getInst().getAdAdSense().j) {
                    if ("frs".equals(this.b.e)) {
                        ThreadCardUtils.jumpToPB(this.b.h, view2.getContext(), 3, false);
                        return;
                    } else if ("index".equals(this.b.e)) {
                        ThreadCardUtils.jumpToPB(this.b.h, view2.getContext(), 2, false);
                        return;
                    } else {
                        ThreadCardUtils.startImageViewer(view2, this.b.f, this.a, i, this.b.h.getThreadData(), this.b.e);
                        return;
                    }
                }
                ThreadCardUtils.startImageViewer(view2, this.b.f, this.a, i, this.b.h.getThreadData(), this.b.e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1429617170, "Lcom/baidu/card/view/MultiImgLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1429617170, "Lcom/baidu/card/view/MultiImgLayout;");
                return;
            }
        }
        ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        j = ii.l(TbadkCoreApplication.getInst()) - ((ii.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + ii.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiImgLayout(Context context) {
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
    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f = true;
        this.h = null;
        this.i = false;
        f();
    }

    public void setConstrainImagePool(xf<TbImageView> xfVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, xfVar) == null) && (constrainImageGroup = this.d) != null) {
            constrainImageGroup.setImageViewPool(xfVar);
        }
    }

    public void setConstrainLayoutPool(xf<ConstrainImageLayout> xfVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, xfVar) == null) && (constrainImageGroup = this.d) != null) {
            constrainImageGroup.setConstrainLayoutPool(xfVar);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i = z;
        }
    }

    public void setPreloadSizeReadyCallback(qm qmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qmVar) == null) {
            this.d.setPreloadSizeReadyCallback(qmVar);
        }
    }

    public void setSingleImageRatio(double d) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d)}) == null) && (constrainImageGroup = this.d) != null) {
            constrainImageGroup.setSingleImageRatio(d);
        }
    }

    public void setSubClickListener(xg6<jw4> xg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, xg6Var) == null) {
            this.g = xg6Var;
        }
    }

    private void setImageData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, threadData) == null) {
            this.d.setFromCDN(this.f);
            this.d.setSinglePicUseStyleV10(true);
            ArrayList<MediaData> medias = threadData.getMedias();
            if (rv4.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.d.setVisibility(0);
                    this.d.setFromCDN(this.f);
                    this.d.setImageClickListener(new b(this, linkedList));
                    this.d.setImageMediaList(linkedList);
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
        if (interceptable == null || interceptable.invokeL(65544, this, threadData) == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hx
    /* renamed from: g */
    public void a(jw4 jw4Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jw4Var) == null) {
            this.h = jw4Var;
            ThreadData threadData = jw4Var.getThreadData();
            ThreadCardUtils.setTitle(this.a, threadData, this.i);
            ThreadCardUtils.setAbstract(this.b, this.a, threadData, j, this.i);
            TextView textView = this.a;
            boolean z3 = false;
            if (textView != null && textView.getVisibility() == 0) {
                z = false;
            } else {
                z = true;
            }
            TextView textView2 = this.b;
            if (textView2 != null && textView2.getVisibility() == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            ConstrainImageGroup constrainImageGroup = this.d;
            if (z && z2) {
                z3 = true;
            }
            ThreadCardUtils.dealMainViewTopMargin(constrainImageGroup, z3, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            setImageData(threadData);
            setVoiceData(threadData);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.b = (TextView) findViewById(R.id.thread_card_abstract);
            this.a = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.c = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            this.d = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
            this.d.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
            tt5 tt5Var = new tt5(3);
            tt5Var.d(1.0d);
            this.d.setImageProcessor(tt5Var);
        }
    }

    public xg6<jw4> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (xg6) invokeV.objValue;
    }

    public void setMarginsTop(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
