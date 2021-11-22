package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.s.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ShareDialogConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener closeAdListener;
    public View.OnClickListener copyLinkListener;
    public int copyTitleId;
    public i.d dialogAddToExpressionListener;
    public i.d dialogDownloadOriginListener;
    public i.d dialogRecognizePicListener;
    public i.d dialogSaveToDiskListener;
    public View.OnClickListener disLikeListener;
    public boolean hasSpecialItem;
    public View.OnClickListener heatingListener;
    public int hideMode;
    public boolean isAddedGood;
    public boolean isCollected;
    public boolean isCopyLink;
    public boolean isFromImmersionVideo;
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
    public boolean isSupportNightMode;
    public boolean mAlaLiveRoomShare;
    public List<Integer> mCommandChannelArray;
    public ArrayList<TransmitForumData> mForumList;
    public From mFrom;
    public boolean mIsAd;
    public boolean mIsAlaLive;
    public boolean mIsShowTransmitShare;
    public boolean mIsVoiceRoom;
    public String mPrePage;
    public int mPrivateThread;
    public boolean mShowMoreForumShare;
    public SparseArray<String> mtjStatistics;
    public DialogInterface.OnCancelListener onCancelListener;
    public DialogInterface.OnDismissListener onDismissListener;
    public View.OnClickListener onWeChatEmotionShareListener;
    public String originImgText;
    public i.d qrCodeClickListener;
    public ShareItem shareItem;
    public boolean showAddEmotion;
    public boolean showDisLike;
    public boolean showHeating;
    public boolean showLocation;
    public boolean showNovelMask;
    public boolean showQRCode;
    public ShareItem[] specialShareItems;
    public ArrayList<Pair<Integer, Pair<Integer, View.OnClickListener>>> textViewList;
    public String topicId;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class From {
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

        public From(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (From) Enum.valueOf(From.class, str) : (From) invokeL.objValue;
        }

        public static From[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (From[]) $VALUES.clone() : (From[]) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
    }

    public void addOutsideTextView(int i2, int i3, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, onClickListener) == null) {
            if (this.textViewList == null) {
                this.textViewList = new ArrayList<>();
            }
            this.textViewList.add(new Pair<>(Integer.valueOf(i2), new Pair(Integer.valueOf(i3), onClickListener)));
        }
    }

    public List<Integer> getCommandChannelArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCommandChannelArray : (List) invokeV.objValue;
    }

    public From getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFrom : (From) invokeV.objValue;
    }

    public String getPrePage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPrePage : (String) invokeV.objValue;
    }

    public boolean isAlaLiveRoomShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAlaLiveRoomShare : invokeV.booleanValue;
    }

    public boolean isPrePagePersonalPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.mPrePage, VideoRecommentPlayActivityConfig.FROM_PERSONAL_PAGE) : invokeV.booleanValue;
    }

    public boolean isShowNovelMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.showNovelMask : invokeV.booleanValue;
    }

    public void setAlaLiveRoomShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mAlaLiveRoomShare = z;
        }
    }

    public void setCopyLinkListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.copyLinkListener = onClickListener;
        }
    }

    public void setCustomCopyTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.copyTitleId = i2;
        }
    }

    public void setFrom(From from) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, from) == null) {
            this.mFrom = from;
        }
    }

    public void setHasSpecialItem(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.hasSpecialItem = z;
        }
    }

    public void setHideMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.hideMode = i2;
        }
    }

    public void setIsAlaLive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsAlaLive = z;
        }
    }

    public void setIsCopyLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.isSetCopyLink = true;
            this.isCopyLink = z;
        }
    }

    public void setIsLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.isLandscape = z;
        }
    }

    public void setIsShowTransmitShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mIsShowTransmitShare = z;
        }
    }

    public void setIsSupportNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.isSupportNightMode = z;
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onDismissListener) == null) {
            this.onDismissListener = onDismissListener;
        }
    }

    public void setPrePage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.mPrePage = str;
        }
    }

    public void setPrivateThread(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mPrivateThread = i2;
        }
    }

    public void setShowNovelMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.showNovelMask = z;
        }
    }

    public void setSpecialShareItems(int i2, ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, shareItem) == null) {
            if (this.specialShareItems == null) {
                this.specialShareItems = new ShareItem[9];
            }
            this.specialShareItems[i2] = shareItem;
        }
    }

    public void setTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.topicId = str;
        }
    }

    public void setTransmitForumList(ArrayList<TransmitForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, arrayList) == null) {
            this.mForumList = arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, SparseArray<String> sparseArray) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), sparseArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.mtjStatistics = sparseArray;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogConfig(Context context, ShareItem shareItem, boolean z, SparseArray<String> sparseArray, boolean z2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Boolean.valueOf(z), sparseArray, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.isLandscape = false;
        this.isSupportNightMode = true;
        this.mIsShowTransmitShare = false;
        this.mShowMoreForumShare = false;
        this.mFrom = From.Default;
        this.showNovelMask = false;
        this.shareItem = shareItem;
        this.showLocation = z;
        this.isInsertBack = z2;
    }
}
