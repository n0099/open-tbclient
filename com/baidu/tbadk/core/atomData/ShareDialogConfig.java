package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.av4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ShareDialogConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener closeAdListener;
    public View.OnClickListener copyLinkListener;
    public int copyTitleId;
    public av4.d dialogAddToExpressionListener;
    public av4.d dialogDownloadOriginListener;
    public av4.d dialogRecognizePicListener;
    public av4.d dialogSaveToDiskListener;
    public View.OnClickListener disLikeListener;
    public String experimentId;
    public boolean hasSpecialItem;
    public View.OnClickListener heatingListener;
    public int hideMode;
    public boolean isAddedGood;
    public boolean isCollected;
    public boolean isCopyLink;
    public boolean isFromImmersionVideo;
    public boolean isHideShareCopyLink;
    public boolean isHost;
    public boolean isImageViewerDialog;
    @Deprecated
    public boolean isInsertBack;
    public boolean isLandscape;
    public boolean isMadeTop;
    public int isManager;
    public int isOriginManager;
    public boolean isSelfHeating;
    public boolean isSetCopyLink;
    public boolean isShowMsg;
    public boolean isShowPersonalLetter;
    public boolean isSupportNightMode;
    public boolean mAlaLiveRoomShare;
    public List mCommandChannelArray;
    public ArrayList mForumList;
    public From mFrom;
    public boolean mIsAd;
    public boolean mIsAlaLive;
    public boolean mIsShowTransmitShare;
    public boolean mIsVoiceRoom;
    public View.OnClickListener mPersonalLetterListener;
    public String mPrePage;
    public int mPrivateThread;
    public boolean mShowMoreForumShare;
    public From mThreadFrom;
    public int msgNum;
    public SparseArray mtjStatistics;
    public DialogInterface.OnCancelListener onCancelListener;
    public DialogInterface.OnDismissListener onDismissListener;
    public View.OnClickListener onWeChatEmotionShareListener;
    public String originImgText;
    public av4.d qrCodeClickListener;
    public ShareItem shareItem;
    public boolean showAddEmotion;
    public boolean showDisLike;
    public boolean showHeating;
    public boolean showLocation;
    public boolean showNovelMask;
    public boolean showQRCode;
    public ShareItem[] specialShareItems;
    public ArrayList textViewList;
    public String topicId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public final class From {
        public static final /* synthetic */ From[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final From Concern;
        public static final From Default;
        public static final From FRS;
        public static final From HomeGameTab;
        public static final From HomeVideoTab;
        public static final From PB;
        public static final From PersonPolymeric;
        public static final From Recommend;
        public static final From VideoMiddlePageHorizontal;
        public static final From VideoMiddlePageVertical;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(223431087, "Lcom/baidu/tbadk/core/atomData/ShareDialogConfig$From;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(223431087, "Lcom/baidu/tbadk/core/atomData/ShareDialogConfig$From;");
                    return;
                }
            }
            Default = new From("Default", 0);
            Recommend = new From("Recommend", 1);
            Concern = new From("Concern", 2);
            PB = new From("PB", 3);
            FRS = new From("FRS", 4);
            PersonPolymeric = new From("PersonPolymeric", 5);
            VideoMiddlePageHorizontal = new From("VideoMiddlePageHorizontal", 6);
            VideoMiddlePageVertical = new From("VideoMiddlePageVertical", 7);
            HomeVideoTab = new From("HomeVideoTab", 8);
            From from = new From("HomeGameTab", 9);
            HomeGameTab = from;
            $VALUES = new From[]{Default, Recommend, Concern, PB, FRS, PersonPolymeric, VideoMiddlePageHorizontal, VideoMiddlePageVertical, HomeVideoTab, from};
        }

        public From(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static From valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (From) Enum.valueOf(From.class, str);
            }
            return (From) invokeL.objValue;
        }

        public static From[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (From[]) $VALUES.clone();
            }
            return (From[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isHideShareCopyLink = false;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        From from = From.Default;
        this.mFrom = from;
        this.mThreadFrom = from;
        this.isShowPersonalLetter = false;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, SparseArray sparseArray) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), sparseArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isHideShareCopyLink = false;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        From from = From.Default;
        this.mFrom = from;
        this.mThreadFrom = from;
        this.isShowPersonalLetter = false;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, SparseArray sparseArray, boolean z2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), sparseArray, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isHideShareCopyLink = false;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        From from = From.Default;
        this.mFrom = from;
        this.mThreadFrom = from;
        this.isShowPersonalLetter = false;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
        this.hasSpecialItem = z2;
        if (z2) {
            this.specialShareItems = new ShareItem[9];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, boolean z2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.showLocation = true;
        this.isSetCopyLink = false;
        this.isCopyLink = false;
        this.copyTitleId = 0;
        this.hasSpecialItem = false;
        this.hideMode = 0;
        this.isHideShareCopyLink = false;
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        From from = From.Default;
        this.mFrom = from;
        this.mThreadFrom = from;
        this.isShowPersonalLetter = false;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.isInsertBack = z2;
    }

    public void addOutsideTextView(int i, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, onClickListener) == null) {
            if (this.textViewList == null) {
                this.textViewList = new ArrayList();
            }
            this.textViewList.add(new Pair(Integer.valueOf(i), new Pair(Integer.valueOf(i2), onClickListener)));
        }
    }

    public List getCommandChannelArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCommandChannelArray;
        }
        return (List) invokeV.objValue;
    }

    public From getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFrom;
        }
        return (From) invokeV.objValue;
    }

    public From getMyThreadFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mThreadFrom;
        }
        return (From) invokeV.objValue;
    }

    public View.OnClickListener getPersonalLetterListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPersonalLetterListener;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public String getPrePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mPrePage;
        }
        return (String) invokeV.objValue;
    }

    public boolean isAlaLiveRoomShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mAlaLiveRoomShare;
        }
        return invokeV.booleanValue;
    }

    public boolean isPrePagePersonalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TextUtils.equals(this.mPrePage, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE);
        }
        return invokeV.booleanValue;
    }

    public boolean isShowNovelMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.showNovelMask;
        }
        return invokeV.booleanValue;
    }

    public void setAlaLiveRoomShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mAlaLiveRoomShare = z;
        }
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.copyLinkListener = onClickListener;
        }
    }

    public void setCustomCopyTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.copyTitleId = i;
        }
    }

    public void setFrom(From from) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, from) == null) {
            this.mFrom = from;
        }
    }

    public void setHasSpecialItem(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.hasSpecialItem = z;
        }
    }

    public void setHideMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.hideMode = i;
        }
    }

    public void setIsAlaLive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsAlaLive = z;
        }
    }

    public void setIsCopyLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isSetCopyLink = true;
            this.isCopyLink = z;
        }
    }

    public void setIsHideShareCopyLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.isHideShareCopyLink = z;
        }
    }

    public void setIsLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.isLandscape = z;
        }
    }

    public void setIsShowTransmitShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsShowTransmitShare = z;
        }
    }

    public void setIsSupportNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isSupportNightMode = z;
        }
    }

    public void setMyThreadFrom(From from) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, from) == null) {
            this.mThreadFrom = from;
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onDismissListener) == null) {
            this.onDismissListener = onDismissListener;
        }
    }

    public void setPersonalLetterListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.mPersonalLetterListener = onClickListener;
        }
    }

    public void setPrePage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.mPrePage = str;
        }
    }

    public void setPrivateThread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.mPrivateThread = i;
        }
    }

    public void setShowNovelMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.showNovelMask = z;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.topicId = str;
        }
    }

    public void setTransmitForumList(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, arrayList) == null) {
            this.mForumList = arrayList;
        }
    }

    public void setSpecialShareItems(int i, ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, shareItem) == null) {
            if (this.specialShareItems == null) {
                this.specialShareItems = new ShareItem[9];
            }
            this.specialShareItems[i] = shareItem;
        }
    }
}
