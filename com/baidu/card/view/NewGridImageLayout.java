package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.tieba.b15;
import com.baidu.tieba.bg;
import com.baidu.tieba.m05;
import com.baidu.tieba.mm;
import com.baidu.tieba.mp6;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.ux;
import com.baidu.tieba.z16;
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
public class NewGridImageLayout extends LinearLayout implements ux<b15>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public TextView b;
    public TextView c;
    public PlayVoiceBntNew d;
    public VoteView e;
    public GridImageLayout f;
    public Context g;
    public b15 h;
    public String i;
    public boolean j;
    public boolean k;
    public mp6<b15> l;
    public boolean m;
    public boolean n;
    public LinkedList<MediaData> o;
    public z16 p;
    public View.OnClickListener q;
    public boolean r;
    public int s;

    public void setPreloadSizeReadyCallback(mm mmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mmVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewGridImageLayout a;

        public a(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mp6<b15> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("2");
                subClickListener.a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewGridImageLayout a;

        public b(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mp6<b15> subClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (subClickListener = this.a.getSubClickListener()) != null) {
                view2.setTag("1");
                subClickListener.a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewGridImageLayout a;

        public c(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.a.j) {
                    z3 = true;
                } else {
                    z3 = this.a.p.u;
                }
                ThreadCardUtils.startImageViewer(view2, z3, this.a.o, i, this.a.h.getThreadData(), this.a.i, this.a.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b15 a;
        public final /* synthetic */ NewGridImageLayout b;

        public d(NewGridImageLayout newGridImageLayout, b15 b15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout, b15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newGridImageLayout;
            this.a = b15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadCardUtils.jumpToPB(this.a.getThreadData().originalThreadData, this.b.g, this.b.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewGridImageLayout a;

        public e(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.jumpToPB(this.a.h.getThreadData().originalThreadData, this.a.g, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewGridImageLayout a;

        public f(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view2, true, this.a.o, i, this.a.h.getThreadData().originalThreadData.b(), this.a.i, this.a.h.getThreadData().originalThreadData.o);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewGridImageLayout a;

        public g(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null) {
                this.a.q.onClick(view2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1813834781, "Lcom/baidu/card/view/NewGridImageLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1813834781, "Lcom/baidu/card/view/NewGridImageLayout;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewGridImageLayout(Context context) {
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

    public final String k(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String picUrl = mediaData.getPicUrl();
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getThumbnails_url();
            }
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getSmallPicUrl();
            }
            if (TextUtils.isEmpty(picUrl)) {
                return mediaData.getSrc_pic();
            }
            return picUrl;
        }
        return (String) invokeL.objValue;
    }

    public final String l(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String smallPicUrl = mediaData.getSmallPicUrl();
            if (TextUtils.isEmpty(smallPicUrl)) {
                smallPicUrl = mediaData.getThumbnails_url();
            }
            if (TextUtils.isEmpty(smallPicUrl)) {
                smallPicUrl = mediaData.getPicUrl();
            }
            if (TextUtils.isEmpty(smallPicUrl)) {
                return mediaData.getSrc_pic();
            }
            return smallPicUrl;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.j = true;
        this.k = true;
        this.m = false;
        this.r = false;
        this.g = context;
        m();
    }

    public final boolean o(PollData pollData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pollData)) == null) {
            if (pollData != null && pollData.getOptions() != null && pollData.getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && (onClickListener = this.q) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            GridImageLayout gridImageLayout = this.f;
            if (gridImageLayout != null) {
                gridImageLayout.p();
            }
            VoteView voteView = this.e;
            if (voteView != null) {
                voteView.D(i);
            }
        }
    }

    public void setCornerStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f.setCornerStyle(i);
        }
    }

    public void setDynamicCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.k = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.i = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.j = z;
        }
    }

    public void setFromForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.s = i;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.r = z;
        }
    }

    public void setSubClickListener(mp6<b15> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, mp6Var) == null) {
            this.l = mp6Var;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.m = z;
        }
    }

    private void setVoiceData(ThreadData threadData) {
        ArrayList<VoiceData.VoiceModel> voice;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, this, threadData) != null) || threadData == null) {
            return;
        }
        if (this.m) {
            this.d.h(new g(this));
        }
        if (threadData.isShareThread && (originalThreadInfo = threadData.originalThreadData) != null) {
            voice = originalThreadInfo.q;
        } else {
            voice = threadData.getVoice();
        }
        if (ListUtils.isEmpty(voice)) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        VoiceData.VoiceModel voiceModel = voice.get(0);
        this.d.setVoiceModel(voiceModel);
        this.d.setTag(voiceModel);
        this.d.b();
        if (voiceModel != null) {
            this.d.j(voiceModel.voice_status.intValue());
        }
        this.d.l();
    }

    public final boolean s(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, threadData)) == null) {
            b15 b15Var = this.h;
            if (b15Var == null || b15Var.getThreadData() == null) {
                return true;
            }
            if (this.h.getThreadData().getTid() != null && !this.h.getThreadData().getTid().equals(threadData.getTid())) {
                return true;
            }
            if (threadData.isShareThread && threadData.originalThreadData != null) {
                if (this.h.getThreadData().originalThreadData == null) {
                    return true;
                }
                return !n(threadData.originalThreadData.h, this.h.getThreadData().originalThreadData.h);
            }
            return !n(threadData.getMedias(), this.h.getThreadData().getMedias());
        }
        return invokeL.booleanValue;
    }

    public mp6<b15> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.l;
        }
        return (mp6) invokeV.objValue;
    }

    public final void j(ThreadData threadData) {
        boolean z;
        String k;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            String first_post_id = threadData.getFirst_post_id();
            if (threadData.isShareThread && (originalThreadInfo = threadData.originalThreadData) != null) {
                if (originalThreadInfo.m) {
                    this.e.setVisibility(8);
                    this.f.setVisibility(8);
                    return;
                }
                medias = originalThreadInfo.h;
                z = true;
            } else {
                z = false;
            }
            if (m05.c().g() && ListUtils.getCount(medias) != 0) {
                this.o.clear();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        if (!z) {
                            if (first_post_id != null) {
                                if (!first_post_id.equals(mediaData.getPostId() + "")) {
                                }
                            }
                        }
                        this.o.add(mediaData);
                    }
                }
                if (ListUtils.getCount(this.o) > 0) {
                    this.f.setVisibility(0);
                    ArrayList<TbRichTextImageInfo> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < this.o.size(); i2++) {
                        MediaData mediaData2 = (MediaData) ListUtils.getItem(this.o, i2);
                        String originalUrl = mediaData2.getOriginalUrl();
                        if (this.o.size() > 1) {
                            k = l(mediaData2);
                        } else {
                            k = k(mediaData2);
                        }
                        TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                        tbRichTextImageInfo.setSrc(k);
                        tbRichTextImageInfo.W(originalUrl);
                        tbRichTextImageInfo.V(mediaData2.isLongPic());
                        int i3 = mediaData2.picWidth;
                        if (i3 > 0 && mediaData2.picHeight > 0) {
                            tbRichTextImageInfo.setWidth(i3);
                            tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                        }
                        arrayList.add(tbRichTextImageInfo);
                    }
                    this.f.setData(arrayList);
                    return;
                }
                this.f.setVisibility(8);
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.thread_card_abstract);
            this.b = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.d = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
            this.f = gridImageLayout;
            gridImageLayout.setSupportGifPlay(false);
            this.f.setCornerStyle(1);
            this.f.setAfterClickListener(new b(this));
            this.p = new z16();
            int i = BdUtilHelper.getScreenDimensions(this.g)[0];
            this.p.J = (i - (BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2)) - (BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005) * 2);
            this.p.K = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
            this.f.setLayoutStrategy(this.p);
            this.o = new LinkedList<>();
            this.f.setOnImageClickListener(new c(this));
            VoteView voteView = (VoteView) findViewById(R.id.thread_card_vote);
            this.e = voteView;
            voteView.setBgColor(R.color.CAM_X0207);
        }
    }

    public final boolean n(ArrayList<MediaData> arrayList, ArrayList<MediaData> arrayList2) {
        InterceptResult invokeLL;
        String k;
        String k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, arrayList2)) == null) {
            if (arrayList == arrayList2) {
                return true;
            }
            if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
                return false;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                MediaData mediaData = arrayList.get(i);
                MediaData mediaData2 = arrayList2.get(i);
                if (size > 1) {
                    k = l(mediaData);
                    k2 = l(mediaData2);
                } else {
                    k = k(mediaData);
                    k2 = k(mediaData2);
                }
                if (k != k2 && (k == null || k2 == null || !k.equals(k2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: p */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null) {
            ThreadData threadData = b15Var.getThreadData();
            OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
            if (originalThreadInfo != null && this.m) {
                r(this.f, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                EMManager.from(this.c).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07);
                EMManager.from(this.b).setTextSize(R.dimen.T_X07);
                this.b.setVisibility(8);
                if (!originalThreadInfo.m && !threadData.shouldShowBlockedState()) {
                    SpannableString c2 = originalThreadInfo.c();
                    ThreadCardUtils.setAbstract(this.c, this.b, c2, threadData, this.a, this.m, this.r);
                    if (c2 != null) {
                        TiePlusEventController.r(originalThreadInfo.h());
                    }
                } else {
                    ThreadCardUtils.setAbstract(this.c, this.b, new SpannableString(this.g.getString(R.string.origin_thread_deleted_title)), threadData, this.a, this.m, this.r);
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
                }
                if (!originalThreadInfo.m && o(originalThreadInfo.G)) {
                    d dVar = new d(this, b15Var);
                    this.e.setOnClickListener(dVar);
                    this.e.setOnItemClickListener(dVar);
                    this.e.setIsTransmit(true);
                    this.e.setData(originalThreadInfo.G, originalThreadInfo.f, originalThreadInfo.e);
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                }
            } else {
                r(this.f, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.e.setVisibility(8);
                this.c.setTextSize(0, BdUtilHelper.getDimens(this.g, R.dimen.T_X06));
                this.c.setLineSpacing(BdUtilHelper.getDimens(this.g, R.dimen.M_T_X002), 1.0f);
                this.b.setTextSize(0, BdUtilHelper.getDimens(this.g, R.dimen.T_X06));
                ThreadCardUtils.setTitle(this.b, threadData, this.r);
                SpannableString abstractText = threadData.getAbstractText();
                ThreadCardUtils.setAbstract(this.c, this.b, abstractText, threadData, this.a, this.m, this.r);
                if (abstractText != null) {
                    TiePlusEventController.r(threadData.getTiePlusLinkOriginData());
                }
            }
            if (s(threadData)) {
                j(threadData);
            }
            setVoiceData(threadData);
            this.h = b15Var;
            if (b15Var.getThreadData().originalThreadData == null) {
                return;
            }
            if (threadData.isShareThread) {
                if (this.h.getThreadData().originalThreadData == null) {
                    return;
                }
                if (!this.h.getThreadData().originalThreadData.m) {
                    this.f.setOnImageClickListener(new e(this));
                }
            }
            if (!this.h.getThreadData().originalThreadData.m) {
                this.f.setOnImageClickListener(new f(this));
            }
            if (this.m) {
                if (this.h.getThreadData().originalThreadData != null && !this.h.getThreadData().originalThreadData.m) {
                    setOnClickListener(this);
                } else {
                    setOnClickListener(null);
                }
                setClickable(true);
                return;
            }
            setOnClickListener(null);
            setClickable(false);
        }
    }

    public final void r(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setObjectPool(bg<ImageView> bgVar, bg<GifView> bgVar2) {
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, bgVar, bgVar2) == null) && (gridImageLayout = this.f) != null) {
            gridImageLayout.setObjectPool(bgVar, bgVar2);
        }
    }
}
