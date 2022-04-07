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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.Cdo;
import com.repackage.af5;
import com.repackage.cn4;
import com.repackage.dg;
import com.repackage.fz;
import com.repackage.oi;
import com.repackage.qn4;
import com.repackage.rx5;
import com.repackage.wr4;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class NewGridImageLayout extends LinearLayout implements fz<qn4>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public TextView b;
    public TextView c;
    public PlayVoiceBntNew d;
    public VoteView e;
    public GridImageLayout f;
    public Context g;
    public qn4 h;
    public String i;
    public boolean j;
    public boolean k;
    public rx5<qn4> l;
    public boolean m;
    public boolean n;
    public LinkedList<MediaData> o;
    public af5 p;
    public View.OnClickListener q;
    public boolean r;
    public int s;

    /* loaded from: classes.dex */
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
            rx5<qn4> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view2.setTag("2");
            subClickListener.a(view2, this.a.h);
        }
    }

    /* loaded from: classes.dex */
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
            rx5<qn4> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view2.setTag("1");
            subClickListener.a(view2, this.a.h);
        }
    }

    /* loaded from: classes.dex */
    public class c implements TbRichTextView.y {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view2, this.a.j ? true : this.a.p.r, this.a.o, i, this.a.h.getThreadData(), this.a.i, this.a.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn4 a;
        public final /* synthetic */ NewGridImageLayout b;

        public d(NewGridImageLayout newGridImageLayout, qn4 qn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout, qn4Var};
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
            this.a = qn4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ThreadCardUtils.jumpToPB(this.a.getThreadData().originalThreadData, this.b.g, this.b.s);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements TbRichTextView.y {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.jumpToPB(this.a.h.getThreadData().originalThreadData, this.a.g, 2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements TbRichTextView.y {
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view2, true, this.a.o, i, this.a.h.getThreadData().originalThreadData.a(), this.a.i, this.a.h.getThreadData().originalThreadData.o);
            }
        }
    }

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.q == null) {
                return;
            }
            this.a.q.onClick(view2);
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
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        oi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
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

    private void setVoiceData(ThreadData threadData) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, threadData) == null) || threadData == null) {
            return;
        }
        if (this.m) {
            this.d.k(new g(this));
        }
        ArrayList<VoiceData.VoiceModel> voice = (!threadData.isShareThread || (originalThreadInfo = threadData.originalThreadData) == null) ? threadData.getVoice() : originalThreadInfo.q;
        if (ListUtils.isEmpty(voice)) {
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        VoiceData.VoiceModel voiceModel = voice.get(0);
        this.d.setVoiceModel(voiceModel);
        this.d.setTag(voiceModel);
        this.d.d();
        if (voiceModel != null) {
            this.d.m(voiceModel.voice_status.intValue());
        }
        this.d.o();
    }

    public rx5<qn4> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (rx5) invokeV.objValue;
    }

    public final void k(ThreadData threadData) {
        boolean z;
        String l;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            ArrayList<MediaData> medias = threadData.getMedias();
            String first_post_id = threadData.getFirst_post_id();
            if (!threadData.isShareThread || (originalThreadInfo = threadData.originalThreadData) == null) {
                z = false;
            } else if (originalThreadInfo.m) {
                this.f.setVisibility(8);
                return;
            } else {
                medias = originalThreadInfo.h;
                z = true;
            }
            if (cn4.c().g() && ListUtils.getCount(medias) != 0) {
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
                            l = m(mediaData2);
                        } else {
                            l = l(mediaData2);
                        }
                        TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                        tbRichTextImageInfo.K(l);
                        tbRichTextImageInfo.J(originalUrl);
                        tbRichTextImageInfo.I(mediaData2.isLongPic());
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

    public final String l(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaData)) == null) {
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
            return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
        }
        return (String) invokeL.objValue;
    }

    public final String m(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaData)) == null) {
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
            return TextUtils.isEmpty(smallPicUrl) ? mediaData.getSrc_pic() : smallPicUrl;
        }
        return (String) invokeL.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f9, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f79);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f87);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f091f88);
            this.d = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.obfuscated_res_0x7f091f7e);
            this.f = gridImageLayout;
            gridImageLayout.setSupportGifPlay(false);
            this.f.setCornerStyle(1);
            this.f.setAfterClickListener(new b(this));
            this.p = new af5();
            int i = oi.p(this.g)[0];
            this.p.G = (i - (oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2)) - (oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005) * 2);
            this.p.H = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
            this.f.setLayoutStrategy(this.p);
            this.o = new LinkedList<>();
            this.f.setOnImageClickListener(new c(this));
            VoteView voteView = (VoteView) findViewById(R.id.obfuscated_res_0x7f091f89);
            this.e = voteView;
            voteView.setBgColor(R.color.CAM_X0207);
        }
    }

    public final boolean o(ArrayList<MediaData> arrayList, ArrayList<MediaData> arrayList2) {
        InterceptResult invokeLL;
        String l;
        String l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, arrayList2)) == null) {
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
                    l = m(mediaData);
                    l2 = m(mediaData2);
                } else {
                    l = l(mediaData);
                    l2 = l(mediaData2);
                }
                if (l != l2 && (l == null || l2 == null || !l.equals(l2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view2) == null) || (onClickListener = this.q) == null) {
            return;
        }
        onClickListener.onClick(view2);
    }

    public final boolean p(PollData pollData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pollData)) == null) ? (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fz
    /* renamed from: r */
    public void a(qn4 qn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, qn4Var) == null) || qn4Var == null || qn4Var.getThreadData() == null) {
            return;
        }
        ThreadData threadData = qn4Var.getThreadData();
        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
        if (originalThreadInfo != null && this.m) {
            t(this.f, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            wr4 d2 = wr4.d(this.c);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            wr4.d(this.b).z(R.dimen.T_X07);
            this.b.setVisibility(8);
            if (!originalThreadInfo.m && !threadData.shouldShowBlockedState()) {
                SpannableString b2 = originalThreadInfo.b();
                ThreadCardUtils.setAbstract(this.c, this.b, b2, threadData, this.a, this.m, this.r);
                if (b2 != null) {
                    TiePlusEventController.p(originalThreadInfo.f());
                }
            } else {
                ThreadCardUtils.setAbstract(this.c, this.b, new SpannableString(this.g.getString(R.string.obfuscated_res_0x7f0f0ce5)), threadData, this.a, this.m, this.r);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
            }
            if (p(originalThreadInfo.G)) {
                d dVar = new d(this, qn4Var);
                this.e.setOnClickListener(dVar);
                this.e.setOnItemClickListener(dVar);
                this.e.setIsTransmit(true);
                this.e.setData(originalThreadInfo.G, originalThreadInfo.f, originalThreadInfo.e);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        } else {
            t(this.f, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            this.e.setVisibility(8);
            this.c.setTextSize(0, oi.f(this.g, R.dimen.T_X06));
            this.c.setLineSpacing(oi.f(this.g, R.dimen.M_T_X002), 1.0f);
            this.b.setTextSize(0, oi.f(this.g, R.dimen.T_X06));
            ThreadCardUtils.setTitle(this.b, threadData, this.r);
            SpannableString abstractText = threadData.getAbstractText();
            ThreadCardUtils.setAbstract(this.c, this.b, abstractText, threadData, this.a, this.m, this.r);
            if (abstractText != null) {
                TiePlusEventController.p(threadData.getTiePlusLinkOriginData());
            }
        }
        if (u(threadData)) {
            k(threadData);
        }
        setVoiceData(threadData);
        this.h = qn4Var;
        if (qn4Var.getThreadData().originalThreadData == null) {
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

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            GridImageLayout gridImageLayout = this.f;
            if (gridImageLayout != null) {
                gridImageLayout.p();
            }
            VoteView voteView = this.e;
            if (voteView != null) {
                voteView.C(i);
            }
        }
    }

    public void setCornerStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f.setCornerStyle(i);
        }
    }

    public void setDynamicCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.k = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.i = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.j = z;
        }
    }

    public void setFromForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.s = i;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.r = z;
        }
    }

    public void setObjectPool(dg<ImageView> dgVar, dg<GifView> dgVar2) {
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, dgVar, dgVar2) == null) || (gridImageLayout = this.f) == null) {
            return;
        }
        gridImageLayout.setObjectPool(dgVar, dgVar2);
    }

    public void setPreloadSizeReadyCallback(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cdo) == null) {
        }
    }

    public void setSubClickListener(rx5<qn4> rx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, rx5Var) == null) {
            this.l = rx5Var;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.m = z;
        }
    }

    public final void t(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048598, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean u(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, threadData)) == null) {
            qn4 qn4Var = this.h;
            if (qn4Var == null || qn4Var.getThreadData() == null) {
                return true;
            }
            if (this.h.getThreadData().getTid() == null || this.h.getThreadData().getTid().equals(threadData.getTid())) {
                if (threadData.isShareThread && threadData.originalThreadData != null) {
                    if (this.h.getThreadData().originalThreadData == null) {
                        return true;
                    }
                    return !o(threadData.originalThreadData.h, this.h.getThreadData().originalThreadData.h);
                }
                return !o(threadData.getMedias(), this.h.getThreadData().getMedias());
            }
            return true;
        }
        return invokeL.booleanValue;
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
        this.a = oi.k(TbadkCoreApplication.getInst()) - ((oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.j = true;
        this.k = true;
        this.m = false;
        this.r = false;
        this.g = context;
        n();
    }
}
