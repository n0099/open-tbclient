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
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.bk6;
import com.baidu.tieba.dv5;
import com.baidu.tieba.gv5;
import com.baidu.tieba.ih;
import com.baidu.tieba.jv4;
import com.baidu.tieba.qs;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.uu4;
import com.baidu.tieba.ya;
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
public class MultiImgLayout extends LinearLayout implements qs<jv4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public PlayVoiceBntNew c;
    public ConstrainImageGroup d;
    public String e;
    public boolean f;
    public bk6<jv4> g;
    public jv4 h;
    public boolean i;

    /* loaded from: classes3.dex */
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
            bk6<jv4> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements gv5 {
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

        @Override // com.baidu.tieba.gv5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (this.b.g != null && this.b.g.c(view2, this.b.h, "")) {
                    return;
                }
                bk6<jv4> subClickListener = this.b.getSubClickListener();
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
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        j = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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
        e();
    }

    public void setConstrainImagePool(ya<TbImageView> yaVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, yaVar) == null) && (constrainImageGroup = this.d) != null) {
            constrainImageGroup.setImageViewPool(yaVar);
        }
    }

    public void setConstrainLayoutPool(ya<ConstrainImageLayout> yaVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, yaVar) == null) && (constrainImageGroup = this.d) != null) {
            constrainImageGroup.setConstrainLayoutPool(yaVar);
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

    public void setPreloadSizeReadyCallback(ih ihVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ihVar) == null) {
            this.d.setPreloadSizeReadyCallback(ihVar);
        }
    }

    public void setSingleImageRatio(double d) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d)}) == null) && (constrainImageGroup = this.d) != null) {
            constrainImageGroup.setSingleImageRatio(d);
        }
    }

    public void setSubClickListener(bk6<jv4> bk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bk6Var) == null) {
            this.g = bk6Var;
        }
    }

    private void setImageData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, threadData) == null) {
            this.d.setFromCDN(this.f);
            this.d.setSinglePicUseStyleV10(true);
            ArrayList<MediaData> medias = threadData.getMedias();
            if (uu4.c().g() && ListUtils.getCount(medias) != 0) {
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
            this.c.b();
            if (voiceModel != null) {
                this.c.j(voiceModel.voice_status.intValue());
            }
            this.c.l();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs
    /* renamed from: f */
    public void onBindDataToView(jv4 jv4Var) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv4Var) == null) {
            this.h = jv4Var;
            ThreadData threadData = jv4Var.getThreadData();
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            dv5 dv5Var = new dv5(3);
            dv5Var.d(1.0d);
            this.d.setImageProcessor(dv5Var);
        }
    }

    public bk6<jv4> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (bk6) invokeV.objValue;
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
