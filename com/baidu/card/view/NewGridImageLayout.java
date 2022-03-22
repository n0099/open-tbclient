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
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.o0.r.l;
import c.a.p0.h0.b0;
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
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class NewGridImageLayout extends LinearLayout implements p<c.a.o0.r.r.a>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25158b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25159c;

    /* renamed from: d  reason: collision with root package name */
    public PlayVoiceBntNew f25160d;

    /* renamed from: e  reason: collision with root package name */
    public VoteView f25161e;

    /* renamed from: f  reason: collision with root package name */
    public GridImageLayout f25162f;

    /* renamed from: g  reason: collision with root package name */
    public Context f25163g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.r.r.a f25164h;
    public String i;
    public boolean j;
    public boolean k;
    public b0<c.a.o0.r.r.a> l;
    public boolean m;
    public boolean n;
    public LinkedList<MediaData> o;
    public c.a.o0.e1.n.a p;
    public View.OnClickListener q;
    public boolean r;
    public int s;

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
        public void onClick(View view) {
            b0<c.a.o0.r.r.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.a.f25164h);
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
        public void onClick(View view) {
            b0<c.a.o0.r.r.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.a.getSubClickListener()) == null) {
                return;
            }
            view.setTag("1");
            subClickListener.a(view, this.a.f25164h);
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(View view, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view, this.a.j ? true : this.a.p.r, this.a.o, i, this.a.f25164h.getThreadData(), this.a.i, this.a.k);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.r.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f25165b;

        public d(NewGridImageLayout newGridImageLayout, c.a.o0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25165b = newGridImageLayout;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadCardUtils.jumpToPB(this.a.getThreadData().originalThreadData, this.f25165b.f25163g, this.f25165b.s);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(View view, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.jumpToPB(this.a.f25164h.getThreadData().originalThreadData, this.a.f25163g, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(View view, String str, int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view, true, this.a.o, i, this.a.f25164h.getThreadData().originalThreadData.a(), this.a.i, this.a.f25164h.getThreadData().originalThreadData.o);
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.q == null) {
                return;
            }
            this.a.q.onClick(view);
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
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
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
            this.f25160d.k(new g(this));
        }
        ArrayList<VoiceData.VoiceModel> voice = (!threadData.isShareThread || (originalThreadInfo = threadData.originalThreadData) == null) ? threadData.getVoice() : originalThreadInfo.q;
        if (ListUtils.isEmpty(voice)) {
            this.f25160d.setVisibility(8);
            return;
        }
        this.f25160d.setVisibility(0);
        VoiceData.VoiceModel voiceModel = voice.get(0);
        this.f25160d.setVoiceModel(voiceModel);
        this.f25160d.setTag(voiceModel);
        this.f25160d.d();
        if (voiceModel != null) {
            this.f25160d.m(voiceModel.voice_status.intValue());
        }
        this.f25160d.o();
    }

    public b0<c.a.o0.r.r.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (b0) invokeV.objValue;
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
                this.f25162f.setVisibility(8);
                return;
            } else {
                medias = originalThreadInfo.f29828h;
                z = true;
            }
            if (l.c().g() && ListUtils.getCount(medias) != 0) {
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
                    this.f25162f.setVisibility(0);
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
                    this.f25162f.setData(arrayList);
                    return;
                }
                this.f25162f.setVisibility(8);
                return;
            }
            this.f25162f.setVisibility(8);
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f7, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f25159c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f8d);
            this.f25158b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f9b);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.f25160d = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.obfuscated_res_0x7f091f92);
            this.f25162f = gridImageLayout;
            gridImageLayout.setSupportGifPlay(false);
            this.f25162f.setCornerStyle(1);
            this.f25162f.setAfterClickListener(new b(this));
            this.p = new c.a.o0.e1.n.a();
            int i = n.p(this.f25163g)[0];
            this.p.G = (i - (n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2)) - (n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005) * 2);
            this.p.H = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
            this.f25162f.setLayoutStrategy(this.p);
            this.o = new LinkedList<>();
            this.f25162f.setOnImageClickListener(new c(this));
            VoteView voteView = (VoteView) findViewById(R.id.obfuscated_res_0x7f091f9d);
            this.f25161e = voteView;
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
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || (onClickListener = this.q) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public final boolean p(PollData pollData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pollData)) == null) ? (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: q */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        ThreadData threadData = aVar.getThreadData();
        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
        if (originalThreadInfo != null && this.m) {
            s(this.f25162f, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f25159c);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            c.a.o0.r.v.c.d(this.f25158b).z(R.dimen.T_X07);
            this.f25158b.setVisibility(8);
            if (!originalThreadInfo.m && !threadData.shouldShowBlockedState()) {
                SpannableString b2 = originalThreadInfo.b();
                ThreadCardUtils.setAbstract(this.f25159c, this.f25158b, b2, threadData, this.a, this.m, this.r);
                if (b2 != null) {
                    TiePlusEventController.h(originalThreadInfo.f());
                }
            } else {
                ThreadCardUtils.setAbstract(this.f25159c, this.f25158b, new SpannableString(this.f25163g.getString(R.string.obfuscated_res_0x7f0f0ce2)), threadData, this.a, this.m, this.r);
                SkinManager.setViewTextColor(this.f25159c, (int) R.color.CAM_X0108);
            }
            if (p(originalThreadInfo.G)) {
                d dVar = new d(this, aVar);
                this.f25161e.setOnClickListener(dVar);
                this.f25161e.setOnItemClickListener(dVar);
                this.f25161e.setIsTransmit(true);
                this.f25161e.setData(originalThreadInfo.G, originalThreadInfo.f29826f, originalThreadInfo.f29825e);
                this.f25161e.setVisibility(0);
            } else {
                this.f25161e.setVisibility(8);
            }
        } else {
            s(this.f25162f, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            this.f25161e.setVisibility(8);
            this.f25159c.setTextSize(0, n.f(this.f25163g, R.dimen.T_X06));
            this.f25159c.setLineSpacing(n.f(this.f25163g, R.dimen.M_T_X002), 1.0f);
            this.f25158b.setTextSize(0, n.f(this.f25163g, R.dimen.T_X06));
            ThreadCardUtils.setTitle(this.f25158b, threadData, this.r);
            SpannableString abstractText = threadData.getAbstractText();
            ThreadCardUtils.setAbstract(this.f25159c, this.f25158b, abstractText, threadData, this.a, this.m, this.r);
            if (abstractText != null) {
                TiePlusEventController.h(threadData.getTiePlusLinkOriginData());
            }
        }
        if (t(threadData)) {
            k(threadData);
        }
        setVoiceData(threadData);
        this.f25164h = aVar;
        if (aVar.getThreadData().originalThreadData == null) {
            return;
        }
        if (threadData.isShareThread) {
            if (this.f25164h.getThreadData().originalThreadData == null) {
                return;
            }
            if (!this.f25164h.getThreadData().originalThreadData.m) {
                this.f25162f.setOnImageClickListener(new e(this));
            }
        }
        if (!this.f25164h.getThreadData().originalThreadData.m) {
            this.f25162f.setOnImageClickListener(new f(this));
        }
        if (this.m) {
            if (this.f25164h.getThreadData().originalThreadData != null && !this.f25164h.getThreadData().originalThreadData.m) {
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

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            GridImageLayout gridImageLayout = this.f25162f;
            if (gridImageLayout != null) {
                gridImageLayout.p();
            }
            VoteView voteView = this.f25161e;
            if (voteView != null) {
                voteView.C(i);
            }
        }
    }

    public final void s(View view, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, view, i) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setCornerStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f25162f.setCornerStyle(i);
        }
    }

    public void setDynamicCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.k = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.i = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.j = z;
        }
    }

    public void setFromForPb(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.s = i;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.q = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.r = z;
        }
    }

    public void setObjectPool(c.a.d.f.k.b<ImageView> bVar, c.a.d.f.k.b<GifView> bVar2) {
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, bVar, bVar2) == null) || (gridImageLayout = this.f25162f) == null) {
            return;
        }
        gridImageLayout.setObjectPool(bVar, bVar2);
    }

    public void setPreloadSizeReadyCallback(c.a.d.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
        }
    }

    public void setSubClickListener(b0<c.a.o0.r.r.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b0Var) == null) {
            this.l = b0Var;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.m = z;
        }
    }

    public final boolean t(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, threadData)) == null) {
            c.a.o0.r.r.a aVar = this.f25164h;
            if (aVar == null || aVar.getThreadData() == null) {
                return true;
            }
            if (this.f25164h.getThreadData().getTid() == null || this.f25164h.getThreadData().getTid().equals(threadData.getTid())) {
                if (threadData.isShareThread && threadData.originalThreadData != null) {
                    if (this.f25164h.getThreadData().originalThreadData == null) {
                        return true;
                    }
                    return !o(threadData.originalThreadData.f29828h, this.f25164h.getThreadData().originalThreadData.f29828h);
                }
                return !o(threadData.getMedias(), this.f25164h.getThreadData().getMedias());
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
        this.a = n.k(TbadkCoreApplication.getInst()) - ((n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.j = true;
        this.k = true;
        this.m = false;
        this.r = false;
        this.f25163g = context;
        n();
    }
}
