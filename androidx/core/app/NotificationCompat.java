package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class NotificationCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: androidx.core.app.NotificationCompat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class Action {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        public static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        public transient /* synthetic */ FieldHolder $fh;
        public PendingIntent actionIntent;
        @Deprecated
        public int icon;
        public boolean mAllowGeneratedReplies;
        public final RemoteInput[] mDataOnlyRemoteInputs;
        public final Bundle mExtras;
        @Nullable
        public IconCompat mIcon;
        public final boolean mIsContextual;
        public final RemoteInput[] mRemoteInputs;
        public final int mSemanticAction;
        public boolean mShowsUserInterface;
        public CharSequence title;

        /* loaded from: classes.dex */
        public static final class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean mAllowGeneratedReplies;
            public final Bundle mExtras;
            public final IconCompat mIcon;
            public final PendingIntent mIntent;
            public boolean mIsContextual;
            public ArrayList<RemoteInput> mRemoteInputs;
            public int mSemanticAction;
            public boolean mShowsUserInterface;
            public final CharSequence mTitle;

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iconCompat, charSequence, pendingIntent};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this((IconCompat) objArr2[0], (CharSequence) objArr2[1], (PendingIntent) objArr2[2], (Bundle) objArr2[3], (RemoteInput[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Integer) objArr2[6]).intValue(), ((Boolean) objArr2[7]).booleanValue(), ((Boolean) objArr2[8]).booleanValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
            }

            private void checkContextualActionNullFields() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mIsContextual && this.mIntent == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public Builder addExtras(Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                    if (bundle != null) {
                        this.mExtras.putAll(bundle);
                    }
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, remoteInput)) == null) {
                    if (this.mRemoteInputs == null) {
                        this.mRemoteInputs = new ArrayList<>();
                    }
                    this.mRemoteInputs.add(remoteInput);
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Action build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    checkContextualActionNullFields();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<RemoteInput> arrayList3 = this.mRemoteInputs;
                    if (arrayList3 != null) {
                        Iterator<RemoteInput> it = arrayList3.iterator();
                        while (it.hasNext()) {
                            RemoteInput next = it.next();
                            if (next.isDataOnly()) {
                                arrayList.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                        }
                    }
                    return new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]), this.mAllowGeneratedReplies, this.mSemanticAction, this.mShowsUserInterface, this.mIsContextual);
                }
                return (Action) invokeV.objValue;
            }

            public Builder extend(Extender extender) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, extender)) == null) {
                    extender.extend(this);
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Bundle getExtras() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mExtras : (Bundle) invokeV.objValue;
            }

            public Builder setAllowGeneratedReplies(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                    this.mAllowGeneratedReplies = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            @NonNull
            public Builder setContextual(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                    this.mIsContextual = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            public Builder setSemanticAction(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                    this.mSemanticAction = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setShowsUserInterface(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                    this.mShowsUserInterface = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Builder(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {Integer.valueOf(i2), charSequence, pendingIntent};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this((IconCompat) objArr2[0], (CharSequence) objArr2[1], (PendingIntent) objArr2[2], (Bundle) objArr2[3], (RemoteInput[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Integer) objArr2[6]).intValue(), ((Boolean) objArr2[7]).booleanValue(), ((Boolean) objArr2[8]).booleanValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Builder(Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual());
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r3;
                    Object[] objArr = {action};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this((IconCompat) objArr2[0], (CharSequence) objArr2[1], (PendingIntent) objArr2[2], (Bundle) objArr2[3], (RemoteInput[]) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Integer) objArr2[6]).intValue(), ((Boolean) objArr2[7]).booleanValue(), ((Boolean) objArr2[8]).booleanValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
            }

            public Builder(@Nullable IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2, boolean z3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iconCompat, charSequence, pendingIntent, bundle, remoteInputArr, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                    interceptable.invokeUnInit(65539, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65539, newInitContext);
                        return;
                    }
                }
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = iconCompat;
                this.mTitle = Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                this.mRemoteInputs = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.mAllowGeneratedReplies = z;
                this.mSemanticAction = i2;
                this.mShowsUserInterface = z2;
                this.mIsContextual = z3;
            }
        }

        /* loaded from: classes.dex */
        public interface Extender {
            Builder extend(Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface SemanticAction {
        }

        /* loaded from: classes.dex */
        public static final class WearableExtender implements Extender {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int DEFAULT_FLAGS = 1;
            public static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            public static final int FLAG_AVAILABLE_OFFLINE = 1;
            public static final int FLAG_HINT_DISPLAY_INLINE = 4;
            public static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            public static final String KEY_CANCEL_LABEL = "cancelLabel";
            public static final String KEY_CONFIRM_LABEL = "confirmLabel";
            public static final String KEY_FLAGS = "flags";
            public static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            public transient /* synthetic */ FieldHolder $fh;
            public CharSequence mCancelLabel;
            public CharSequence mConfirmLabel;
            public int mFlags;
            public CharSequence mInProgressLabel;

            public WearableExtender() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mFlags = 1;
            }

            private void setFlag(int i2, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                    if (z) {
                        this.mFlags = i2 | this.mFlags;
                    } else {
                        this.mFlags = (~i2) & this.mFlags;
                    }
                }
            }

            @Override // androidx.core.app.NotificationCompat.Action.Extender
            public Builder extend(Builder builder) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) {
                    Bundle bundle = new Bundle();
                    int i2 = this.mFlags;
                    if (i2 != 1) {
                        bundle.putInt("flags", i2);
                    }
                    CharSequence charSequence = this.mInProgressLabel;
                    if (charSequence != null) {
                        bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                    }
                    CharSequence charSequence2 = this.mConfirmLabel;
                    if (charSequence2 != null) {
                        bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
                    }
                    CharSequence charSequence3 = this.mCancelLabel;
                    if (charSequence3 != null) {
                        bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
                    }
                    builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                    return builder;
                }
                return (Builder) invokeL.objValue;
            }

            @Deprecated
            public CharSequence getCancelLabel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCancelLabel : (CharSequence) invokeV.objValue;
            }

            @Deprecated
            public CharSequence getConfirmLabel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mConfirmLabel : (CharSequence) invokeV.objValue;
            }

            public boolean getHintDisplayActionInline() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.mFlags & 4) != 0 : invokeV.booleanValue;
            }

            public boolean getHintLaunchesActivity() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.mFlags & 2) != 0 : invokeV.booleanValue;
            }

            @Deprecated
            public CharSequence getInProgressLabel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mInProgressLabel : (CharSequence) invokeV.objValue;
            }

            public boolean isAvailableOffline() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (this.mFlags & 1) != 0 : invokeV.booleanValue;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                    setFlag(1, z);
                    return this;
                }
                return (WearableExtender) invokeZ.objValue;
            }

            @Deprecated
            public WearableExtender setCancelLabel(CharSequence charSequence) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, charSequence)) == null) {
                    this.mCancelLabel = charSequence;
                    return this;
                }
                return (WearableExtender) invokeL.objValue;
            }

            @Deprecated
            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
                    this.mConfirmLabel = charSequence;
                    return this;
                }
                return (WearableExtender) invokeL.objValue;
            }

            public WearableExtender setHintDisplayActionInline(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                    setFlag(4, z);
                    return this;
                }
                return (WearableExtender) invokeZ.objValue;
            }

            public WearableExtender setHintLaunchesActivity(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                    setFlag(2, z);
                    return this;
                }
                return (WearableExtender) invokeZ.objValue;
            }

            @Deprecated
            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, charSequence)) == null) {
                    this.mInProgressLabel = charSequence;
                    return this;
                }
                return (WearableExtender) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* renamed from: clone */
            public WearableExtender m3clone() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    WearableExtender wearableExtender = new WearableExtender();
                    wearableExtender.mFlags = this.mFlags;
                    wearableExtender.mInProgressLabel = this.mInProgressLabel;
                    wearableExtender.mConfirmLabel = this.mConfirmLabel;
                    wearableExtender.mCancelLabel = this.mCancelLabel;
                    return wearableExtender;
                }
                return (WearableExtender) invokeV.objValue;
            }

            public WearableExtender(Action action) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {action};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.mFlags = 1;
                Bundle bundle = action.getExtras().getBundle("android.wearable.EXTENSIONS");
                if (bundle != null) {
                    this.mFlags = bundle.getInt("flags", 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Action(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), charSequence, pendingIntent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((IconCompat) objArr2[0], (CharSequence) objArr2[1], (PendingIntent) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public PendingIntent getActionIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.actionIntent : (PendingIntent) invokeV.objValue;
        }

        public boolean getAllowGeneratedReplies() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAllowGeneratedReplies : invokeV.booleanValue;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDataOnlyRemoteInputs : (RemoteInput[]) invokeV.objValue;
        }

        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mExtras : (Bundle) invokeV.objValue;
        }

        @Deprecated
        public int getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.icon : invokeV.intValue;
        }

        @Nullable
        public IconCompat getIconCompat() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.mIcon == null && (i2 = this.icon) != 0) {
                    this.mIcon = IconCompat.createWithResource(null, "", i2);
                }
                return this.mIcon;
            }
            return (IconCompat) invokeV.objValue;
        }

        public RemoteInput[] getRemoteInputs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRemoteInputs : (RemoteInput[]) invokeV.objValue;
        }

        public int getSemanticAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSemanticAction : invokeV.intValue;
        }

        public boolean getShowsUserInterface() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mShowsUserInterface : invokeV.booleanValue;
        }

        public CharSequence getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.title : (CharSequence) invokeV.objValue;
        }

        public boolean isContextual() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mIsContextual : invokeV.booleanValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {iconCompat, charSequence, pendingIntent};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((IconCompat) objArr2[0], (CharSequence) objArr2[1], (PendingIntent) objArr2[2], (Bundle) objArr2[3], (RemoteInput[]) objArr2[4], (RemoteInput[]) objArr2[5], ((Boolean) objArr2[6]).booleanValue(), ((Integer) objArr2[7]).intValue(), ((Boolean) objArr2[8]).booleanValue(), ((Boolean) objArr2[9]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Action(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i3, boolean z2, boolean z3) {
            this(i2 != 0 ? IconCompat.createWithResource(null, "", i2) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, i3, z2, z3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Integer.valueOf(i2), charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((IconCompat) objArr2[0], (CharSequence) objArr2[1], (PendingIntent) objArr2[2], (Bundle) objArr2[3], (RemoteInput[]) objArr2[4], (RemoteInput[]) objArr2[5], ((Boolean) objArr2[6]).booleanValue(), ((Integer) objArr2[7]).intValue(), ((Boolean) objArr2[8]).booleanValue(), ((Boolean) objArr2[9]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public Action(@Nullable IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iconCompat, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mShowsUserInterface = true;
            this.mIcon = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new Bundle() : bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mDataOnlyRemoteInputs = remoteInputArr2;
            this.mAllowGeneratedReplies = z;
            this.mSemanticAction = i2;
            this.mShowsUserInterface = z2;
            this.mIsContextual = z3;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface BadgeIconType {
    }

    /* loaded from: classes.dex */
    public static class BigPictureStyle extends Style {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap mBigLargeIcon;
        public boolean mBigLargeIconSet;
        public Bitmap mPicture;

        public BigPictureStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, notificationBuilderWithBuilderAccessor) == null) || Build.VERSION.SDK_INT < 16) {
                return;
            }
            Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigPicture(this.mPicture);
            if (this.mBigLargeIconSet) {
                bigPicture.bigLargeIcon(this.mBigLargeIcon);
            }
            if (this.mSummaryTextSet) {
                bigPicture.setSummaryText(this.mSummaryText);
            }
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
                this.mBigLargeIcon = bitmap;
                this.mBigLargeIconSet = true;
                return this;
            }
            return (BigPictureStyle) invokeL.objValue;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
                this.mPicture = bitmap;
                return this;
            }
            return (BigPictureStyle) invokeL.objValue;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
                this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
                return this;
            }
            return (BigPictureStyle) invokeL.objValue;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, charSequence)) == null) {
                this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
                this.mSummaryTextSet = true;
                return this;
            }
            return (BigPictureStyle) invokeL.objValue;
        }

        public BigPictureStyle(Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence mBigText;

        public BigTextStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, notificationBuilderWithBuilderAccessor) == null) || Build.VERSION.SDK_INT < 16) {
                return;
            }
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet) {
                bigText.setSummaryText(this.mSummaryText);
            }
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
                this.mBigText = Builder.limitCharSequenceLength(charSequence);
                return this;
            }
            return (BigTextStyle) invokeL.objValue;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence)) == null) {
                this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
                return this;
            }
            return (BigTextStyle) invokeL.objValue;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
                this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
                this.mSummaryTextSet = true;
                return this;
            }
            return (BigTextStyle) invokeL.objValue;
        }

        public BigTextStyle(Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static final class BubbleMetadata {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        public static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public PendingIntent mDeleteIntent;
        public int mDesiredHeight;
        @DimenRes
        public int mDesiredHeightResId;
        public int mFlags;
        public IconCompat mIcon;
        public PendingIntent mPendingIntent;

        /* loaded from: classes.dex */
        public static final class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public PendingIntent mDeleteIntent;
            public int mDesiredHeight;
            @DimenRes
            public int mDesiredHeightResId;
            public int mFlags;
            public IconCompat mIcon;
            public PendingIntent mPendingIntent;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            private Builder setFlag(int i2, boolean z) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                    if (z) {
                        this.mFlags = i2 | this.mFlags;
                    } else {
                        this.mFlags = (~i2) & this.mFlags;
                    }
                    return this;
                }
                return (Builder) invokeCommon.objValue;
            }

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public BubbleMetadata build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PendingIntent pendingIntent = this.mPendingIntent;
                    if (pendingIntent != null) {
                        IconCompat iconCompat = this.mIcon;
                        if (iconCompat != null) {
                            return new BubbleMetadata(pendingIntent, this.mDeleteIntent, iconCompat, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, null);
                        }
                        throw new IllegalStateException("Must supply an icon for the bubble");
                    }
                    throw new IllegalStateException("Must supply pending intent to bubble");
                }
                return (BubbleMetadata) invokeV.objValue;
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                    setFlag(1, z);
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pendingIntent)) == null) {
                    this.mDeleteIntent = pendingIntent;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                    this.mDesiredHeight = Math.max(i2, 0);
                    this.mDesiredHeightResId = 0;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                    this.mDesiredHeightResId = i2;
                    this.mDesiredHeight = 0;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat iconCompat) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iconCompat)) == null) {
                    if (iconCompat != null) {
                        if (iconCompat.getType() != 1) {
                            this.mIcon = iconCompat;
                            return this;
                        }
                        throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
                    }
                    throw new IllegalArgumentException("Bubbles require non-null icon");
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent pendingIntent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pendingIntent)) == null) {
                    if (pendingIntent != null) {
                        this.mPendingIntent = pendingIntent;
                        return this;
                    }
                    throw new IllegalArgumentException("Bubble requires non-null pending intent");
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setSuppressNotification(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                    setFlag(2, z);
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }
        }

        public /* synthetic */ BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i2, int i3, int i4, AnonymousClass1 anonymousClass1) {
            this(pendingIntent, pendingIntent2, iconCompat, i2, i3, i4);
        }

        @Nullable
        @RequiresApi(29)
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bubbleMetadata)) == null) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Builder suppressNotification = new Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(bubbleMetadata.getIcon())).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return suppressNotification.build();
            }
            return (BubbleMetadata) invokeL.objValue;
        }

        @Nullable
        @RequiresApi(29)
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bubbleMetadata)) == null) {
                if (bubbleMetadata == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return suppressNotification.build();
            }
            return (Notification.BubbleMetadata) invokeL.objValue;
        }

        public boolean getAutoExpandBubble() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.mFlags & 1) != 0 : invokeV.booleanValue;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDeleteIntent : (PendingIntent) invokeV.objValue;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDesiredHeight : invokeV.intValue;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDesiredHeightResId : invokeV.intValue;
        }

        @NonNull
        public IconCompat getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIcon : (IconCompat) invokeV.objValue;
        }

        @NonNull
        public PendingIntent getIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPendingIntent : (PendingIntent) invokeV.objValue;
        }

        public boolean isNotificationSuppressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.mFlags & 2) != 0 : invokeV.booleanValue;
        }

        public BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i2, @DimenRes int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pendingIntent, pendingIntent2, iconCompat, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPendingIntent = pendingIntent;
            this.mIcon = iconCompat;
            this.mDesiredHeight = i2;
            this.mDesiredHeightResId = i3;
            this.mDeleteIntent = pendingIntent2;
            this.mFlags = i4;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public transient /* synthetic */ FieldHolder $fh;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;
        public boolean mAllowSystemGeneratedContextualActions;
        public int mBadgeIcon;
        public RemoteViews mBigContentView;
        public BubbleMetadata mBubbleMetadata;
        public String mCategory;
        public String mChannelId;
        public boolean mChronometerCountDown;
        public int mColor;
        public boolean mColorized;
        public boolean mColorizedSet;
        public CharSequence mContentInfo;
        public PendingIntent mContentIntent;
        public CharSequence mContentText;
        public CharSequence mContentTitle;
        public RemoteViews mContentView;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;
        public Bundle mExtras;
        public PendingIntent mFullScreenIntent;
        public int mGroupAlertBehavior;
        public String mGroupKey;
        public boolean mGroupSummary;
        public RemoteViews mHeadsUpContentView;
        public ArrayList<Action> mInvisibleActions;
        public Bitmap mLargeIcon;
        public boolean mLocalOnly;
        public Notification mNotification;
        public int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        public int mPriority;
        public int mProgress;
        public boolean mProgressIndeterminate;
        public int mProgressMax;
        public Notification mPublicVersion;
        public CharSequence[] mRemoteInputHistory;
        public String mShortcutId;
        public boolean mShowWhen;
        public boolean mSilent;
        public String mSortKey;
        public Style mStyle;
        public CharSequence mSubText;
        public RemoteViews mTickerView;
        public long mTimeout;
        public boolean mUseChronometer;
        public int mVisibility;

        public Builder(@NonNull Context context, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mActions = new ArrayList<>();
            this.mInvisibleActions = new ArrayList<>();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            Notification notification = new Notification();
            this.mNotification = notification;
            this.mContext = context;
            this.mChannelId = str;
            notification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList<>();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, charSequence)) == null) ? (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence : (CharSequence) invokeL.objValue;
        }

        private Bitmap reduceLargeIconSize(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bitmap)) == null) {
                if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                    return bitmap;
                }
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
                return bitmap;
            }
            return (Bitmap) invokeL.objValue;
        }

        private void setFlag(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (z) {
                    Notification notification = this.mNotification;
                    notification.flags = i2 | notification.flags;
                    return;
                }
                Notification notification2 = this.mNotification;
                notification2.flags = (~i2) & notification2.flags;
            }
        }

        public Builder addAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, charSequence, pendingIntent)) == null) {
                this.mActions.add(new Action(i2, charSequence, pendingIntent));
                return this;
            }
            return (Builder) invokeILL.objValue;
        }

        public Builder addExtras(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                if (bundle != null) {
                    Bundle bundle2 = this.mExtras;
                    if (bundle2 == null) {
                        this.mExtras = new Bundle(bundle);
                    } else {
                        bundle2.putAll(bundle);
                    }
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, charSequence, pendingIntent)) == null) ? addInvisibleAction(new Action(i2, charSequence, pendingIntent)) : (Builder) invokeILL.objValue;
        }

        public Builder addPerson(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mPeople.add(str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Notification build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new NotificationCompatBuilder(this).build() : (Notification) invokeV.objValue;
        }

        public Builder extend(Extender extender) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, extender)) == null) {
                extender.extend(this);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mBigContentView : (RemoteViews) invokeV.objValue;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mBubbleMetadata : (BubbleMetadata) invokeV.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mColor : invokeV.intValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mContentView : (RemoteViews) invokeV.objValue;
        }

        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.mExtras == null) {
                    this.mExtras = new Bundle();
                }
                return this.mExtras;
            }
            return (Bundle) invokeV.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mHeadsUpContentView : (RemoteViews) invokeV.objValue;
        }

        @Deprecated
        public Notification getNotification() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? build() : (Notification) invokeV.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPriority : invokeV.intValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (this.mShowWhen) {
                    return this.mNotification.when;
                }
                return 0L;
            }
            return invokeV.longValue;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                this.mAllowSystemGeneratedContextualActions = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setAutoCancel(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
                setFlag(16, z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setBadgeIconType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                this.mBadgeIcon = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata bubbleMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, bubbleMetadata)) == null) {
                this.mBubbleMetadata = bubbleMetadata;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCategory(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
                this.mCategory = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setChannelId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                this.mChannelId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        @RequiresApi(24)
        public Builder setChronometerCountDown(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
                this.mChronometerCountDown = z;
                this.mExtras.putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setColor(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                this.mColor = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setColorized(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                this.mColorized = z;
                this.mColorizedSet = true;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setContent(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, remoteViews)) == null) {
                this.mNotification.contentView = remoteViews;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, charSequence)) == null) {
                this.mContentInfo = limitCharSequenceLength(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, pendingIntent)) == null) {
                this.mContentIntent = pendingIntent;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setContentText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, charSequence)) == null) {
                this.mContentText = limitCharSequenceLength(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, charSequence)) == null) {
                this.mContentTitle = limitCharSequenceLength(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, remoteViews)) == null) {
                this.mBigContentView = remoteViews;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, remoteViews)) == null) {
                this.mContentView = remoteViews;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, remoteViews)) == null) {
                this.mHeadsUpContentView = remoteViews;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDefaults(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
                Notification notification = this.mNotification;
                notification.defaults = i2;
                if ((i2 & 4) != 0) {
                    notification.flags |= 1;
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, pendingIntent)) == null) {
                this.mNotification.deleteIntent = pendingIntent;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtras(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bundle)) == null) {
                this.mExtras = bundle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048613, this, pendingIntent, z)) == null) {
                this.mFullScreenIntent = pendingIntent;
                setFlag(128, z);
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }

        public Builder setGroup(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
                this.mGroupKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setGroupAlertBehavior(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
                this.mGroupAlertBehavior = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setGroupSummary(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
                this.mGroupSummary = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, bitmap)) == null) {
                this.mLargeIcon = reduceLargeIconSize(bitmap);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLights(@ColorInt int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(1048618, this, i2, i3, i4)) == null) {
                Notification notification = this.mNotification;
                notification.ledARGB = i2;
                notification.ledOnMS = i3;
                notification.ledOffMS = i4;
                int i5 = (i3 == 0 || i4 == 0) ? 0 : 1;
                Notification notification2 = this.mNotification;
                notification2.flags = i5 | (notification2.flags & (-2));
                return this;
            }
            return (Builder) invokeIII.objValue;
        }

        public Builder setLocalOnly(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
                this.mLocalOnly = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setNotificationSilent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
                this.mSilent = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder setNumber(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
                this.mNumber = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setOngoing(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
                setFlag(2, z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048623, this, z)) == null) {
                setFlag(8, z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPriority(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) {
                this.mPriority = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setProgress(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                this.mProgressMax = i2;
                this.mProgress = i3;
                this.mProgressIndeterminate = z;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setPublicVersion(Notification notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, notification)) == null) {
                this.mPublicVersion = notification;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRemoteInputHistory(CharSequence[] charSequenceArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, charSequenceArr)) == null) {
                this.mRemoteInputHistory = charSequenceArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setShortcutId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
                this.mShortcutId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setShowWhen(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
                this.mShowWhen = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSmallIcon(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
                this.mNotification.icon = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setSortKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
                this.mSortKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSound(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, uri)) == null) {
                Notification notification = this.mNotification;
                notification.sound = uri;
                notification.audioStreamType = -1;
                if (Build.VERSION.SDK_INT >= 21) {
                    notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setStyle(Style style) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, style)) == null) {
                if (this.mStyle != style) {
                    this.mStyle = style;
                    if (style != null) {
                        style.setBuilder(this);
                    }
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSubText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, charSequence)) == null) {
                this.mSubText = limitCharSequenceLength(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTicker(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, charSequence)) == null) {
                this.mNotification.tickerText = limitCharSequenceLength(charSequence);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTimeoutAfter(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048639, this, j2)) == null) {
                this.mTimeout = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder setUsesChronometer(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z)) == null) {
                this.mUseChronometer = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVibrate(long[] jArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, jArr)) == null) {
                this.mNotification.vibrate = jArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setVisibility(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i2)) == null) {
                this.mVisibility = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setWhen(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048643, this, j2)) == null) {
                this.mNotification.when = j2;
                return this;
            }
            return (Builder) invokeJ.objValue;
        }

        public Builder addAction(Action action) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action)) == null) {
                this.mActions.add(action);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @RequiresApi(21)
        public Builder addInvisibleAction(Action action) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, action)) == null) {
                this.mInvisibleActions.add(action);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSmallIcon(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048631, this, i2, i3)) == null) {
                Notification notification = this.mNotification;
                notification.icon = i2;
                notification.iconLevel = i3;
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048638, this, charSequence, remoteViews)) == null) {
                this.mNotification.tickerText = limitCharSequenceLength(charSequence);
                this.mTickerView = remoteViews;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setSound(Uri uri, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048634, this, uri, i2)) == null) {
                Notification notification = this.mNotification;
                notification.sound = uri;
                notification.audioStreamType = i2;
                if (Build.VERSION.SDK_INT >= 21) {
                    notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i2).build();
                }
                return this;
            }
            return (Builder) invokeLI.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public Builder(Context context) {
            this(context, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class DecoratedCustomViewStyle extends Style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_ACTION_BUTTONS = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public DecoratedCustomViewStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean z) {
            InterceptResult invokeLZ;
            int min;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, remoteViews, z)) == null) {
                boolean z2 = true;
                RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
                applyStandardTemplate.removeAllViews(R.id.actions);
                List<Action> nonContextualActions = getNonContextualActions(this.mBuilder.mActions);
                if (!z || nonContextualActions == null || (min = Math.min(nonContextualActions.size(), 3)) <= 0) {
                    z2 = false;
                } else {
                    for (int i2 = 0; i2 < min; i2++) {
                        applyStandardTemplate.addView(R.id.actions, generateActionButton(nonContextualActions.get(i2)));
                    }
                }
                int i3 = z2 ? 0 : 8;
                applyStandardTemplate.setViewVisibility(R.id.actions, i3);
                applyStandardTemplate.setViewVisibility(R.id.action_divider, i3);
                buildIntoRemoteViews(applyStandardTemplate, remoteViews);
                return applyStandardTemplate;
            }
            return (RemoteViews) invokeLZ.objValue;
        }

        private RemoteViews generateActionButton(Action action) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, action)) == null) {
                boolean z = action.actionIntent == null;
                String packageName = this.mBuilder.mContext.getPackageName();
                if (z) {
                    i2 = R.layout.notification_action_tombstone;
                } else {
                    i2 = R.layout.notification_action;
                }
                RemoteViews remoteViews = new RemoteViews(packageName, i2);
                remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(action.getIconCompat(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
                remoteViews.setTextViewText(R.id.action_text, action.title);
                if (!z) {
                    remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
                }
                if (Build.VERSION.SDK_INT >= 15) {
                    remoteViews.setContentDescription(R.id.action_container, action.title);
                }
                return remoteViews;
            }
            return (RemoteViews) invokeL.objValue;
        }

        public static List<Action> getNonContextualActions(List<Action> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
                if (list == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Action action : list) {
                    if (!action.isContextual()) {
                        arrayList.add(action);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, notificationBuilderWithBuilderAccessor) == null) || Build.VERSION.SDK_INT < 24) {
                return;
            }
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return null;
                }
                RemoteViews bigContentView = this.mBuilder.getBigContentView();
                if (bigContentView == null) {
                    bigContentView = this.mBuilder.getContentView();
                }
                if (bigContentView == null) {
                    return null;
                }
                return createRemoteViews(bigContentView, true);
            }
            return (RemoteViews) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                    return createRemoteViews(this.mBuilder.getContentView(), false);
                }
                return null;
            }
            return (RemoteViews) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return null;
                }
                RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
                RemoteViews contentView = headsUpContentView != null ? headsUpContentView : this.mBuilder.getContentView();
                if (headsUpContentView == null) {
                    return null;
                }
                return createRemoteViews(contentView, true);
            }
            return (RemoteViews) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface Extender {
        Builder extend(Builder builder);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface GroupAlertBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface NotificationVisibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface StreamType {
    }

    /* loaded from: classes.dex */
    public static abstract class Style {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence mBigContentTitle;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder mBuilder;
        public CharSequence mSummaryText;
        public boolean mSummaryTextSet;

        public Style() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSummaryTextSet = false;
        }

        private int calculateTopPadding() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                Resources resources = this.mBuilder.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
                float constrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
                return Math.round(((1.0f - constrain) * dimensionPixelSize) + (constrain * dimensionPixelSize2));
            }
            return invokeV.intValue;
        }

        public static float constrain(float f2, float f3, float f4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 < f3 ? f3 : f2 > f4 ? f4 : f2 : invokeCommon.floatValue;
        }

        private Bitmap createIconWithBackground(int i2, int i3, int i4, int i5) {
            InterceptResult invokeIIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIII = interceptable.invokeIIII(AdIconUtil.AD_TEXT_ID, this, i2, i3, i4, i5)) == null) {
                int i6 = R.drawable.notification_icon_background;
                if (i5 == 0) {
                    i5 = 0;
                }
                Bitmap createColoredBitmap = createColoredBitmap(i6, i5, i3);
                Canvas canvas = new Canvas(createColoredBitmap);
                Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i2).mutate();
                mutate.setFilterBitmap(true);
                int i7 = (i3 - i4) / 2;
                int i8 = i4 + i7;
                mutate.setBounds(i7, i7, i8, i8);
                mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
                mutate.draw(canvas);
                return createColoredBitmap;
            }
            return (Bitmap) invokeIIII.objValue;
        }

        private void hideNormalContent(RemoteViews remoteViews) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, remoteViews) == null) {
                remoteViews.setViewVisibility(R.id.title, 8);
                remoteViews.setViewVisibility(R.id.text2, 8);
                remoteViews.setViewVisibility(R.id.text, 8);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notificationBuilderWithBuilderAccessor) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:67:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x019b  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0215  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x021a  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x021c  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0226  */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RemoteViews applyStandardTemplate(boolean z, int i2, boolean z2) {
            InterceptResult invokeCommon;
            boolean z3;
            CharSequence charSequence;
            boolean z4;
            CharSequence charSequence2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
                Resources resources = this.mBuilder.mContext.getResources();
                RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), i2);
                boolean z5 = true;
                boolean z6 = this.mBuilder.getPriority() < -1;
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 16 && i3 < 21) {
                    if (z6) {
                        remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
                        remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
                    } else {
                        remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
                        remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
                    }
                }
                Builder builder = this.mBuilder;
                if (builder.mLargeIcon != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        remoteViews.setViewVisibility(R.id.icon, 0);
                        remoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
                    } else {
                        remoteViews.setViewVisibility(R.id.icon, 8);
                    }
                    if (z && this.mBuilder.mNotification.icon != 0) {
                        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                        int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                        if (Build.VERSION.SDK_INT >= 21) {
                            Builder builder2 = this.mBuilder;
                            remoteViews.setImageViewBitmap(R.id.right_icon, createIconWithBackground(builder2.mNotification.icon, dimensionPixelSize, dimensionPixelSize2, builder2.getColor()));
                        } else {
                            remoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                        }
                        remoteViews.setViewVisibility(R.id.right_icon, 0);
                    }
                } else if (z && builder.mNotification.icon != 0) {
                    remoteViews.setViewVisibility(R.id.icon, 0);
                    if (Build.VERSION.SDK_INT >= 21) {
                        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
                        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
                        Builder builder3 = this.mBuilder;
                        remoteViews.setImageViewBitmap(R.id.icon, createIconWithBackground(builder3.mNotification.icon, dimensionPixelSize3, dimensionPixelSize4, builder3.getColor()));
                    } else {
                        remoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                    }
                }
                CharSequence charSequence3 = this.mBuilder.mContentTitle;
                if (charSequence3 != null) {
                    remoteViews.setTextViewText(R.id.title, charSequence3);
                }
                CharSequence charSequence4 = this.mBuilder.mContentText;
                if (charSequence4 != null) {
                    remoteViews.setTextViewText(R.id.text, charSequence4);
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z7 = Build.VERSION.SDK_INT < 21 && this.mBuilder.mLargeIcon != null;
                Builder builder4 = this.mBuilder;
                CharSequence charSequence5 = builder4.mContentInfo;
                if (charSequence5 != null) {
                    remoteViews.setTextViewText(R.id.info, charSequence5);
                    remoteViews.setViewVisibility(R.id.info, 0);
                } else if (builder4.mNumber > 0) {
                    if (this.mBuilder.mNumber > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                        remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
                    } else {
                        remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(this.mBuilder.mNumber));
                    }
                    remoteViews.setViewVisibility(R.id.info, 0);
                } else {
                    remoteViews.setViewVisibility(R.id.info, 8);
                    charSequence = this.mBuilder.mSubText;
                    if (charSequence != null && Build.VERSION.SDK_INT >= 16) {
                        remoteViews.setTextViewText(R.id.text, charSequence);
                        charSequence2 = this.mBuilder.mContentText;
                        if (charSequence2 == null) {
                            remoteViews.setTextViewText(R.id.text2, charSequence2);
                            remoteViews.setViewVisibility(R.id.text2, 0);
                            z4 = true;
                            if (z4 && Build.VERSION.SDK_INT >= 16) {
                                if (z2) {
                                    remoteViews.setTextViewTextSize(R.id.text, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                                }
                                remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                            }
                            if (this.mBuilder.getWhenIfShowing() == 0) {
                                z5 = z7;
                            } else if (this.mBuilder.mUseChronometer && Build.VERSION.SDK_INT >= 16) {
                                remoteViews.setViewVisibility(R.id.chronometer, 0);
                                remoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                                remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                                boolean z8 = this.mBuilder.mChronometerCountDown;
                                if (z8 && Build.VERSION.SDK_INT >= 24) {
                                    remoteViews.setChronometerCountDown(R.id.chronometer, z8);
                                }
                            } else {
                                remoteViews.setViewVisibility(R.id.time, 0);
                                remoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
                            }
                            remoteViews.setViewVisibility(R.id.right_side, z5 ? 0 : 8);
                            remoteViews.setViewVisibility(R.id.line3, z3 ? 0 : 8);
                            return remoteViews;
                        }
                        remoteViews.setViewVisibility(R.id.text2, 8);
                    }
                    z4 = false;
                    if (z4) {
                        if (z2) {
                        }
                        remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                    }
                    if (this.mBuilder.getWhenIfShowing() == 0) {
                    }
                    remoteViews.setViewVisibility(R.id.right_side, z5 ? 0 : 8);
                    remoteViews.setViewVisibility(R.id.line3, z3 ? 0 : 8);
                    return remoteViews;
                }
                z3 = true;
                z7 = true;
                charSequence = this.mBuilder.mSubText;
                if (charSequence != null) {
                    remoteViews.setTextViewText(R.id.text, charSequence);
                    charSequence2 = this.mBuilder.mContentText;
                    if (charSequence2 == null) {
                    }
                }
                z4 = false;
                if (z4) {
                }
                if (this.mBuilder.getWhenIfShowing() == 0) {
                }
                remoteViews.setViewVisibility(R.id.right_side, z5 ? 0 : 8);
                remoteViews.setViewVisibility(R.id.line3, z3 ? 0 : 8);
                return remoteViews;
            }
            return (RemoteViews) invokeCommon.objValue;
        }

        public Notification build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Builder builder = this.mBuilder;
                if (builder != null) {
                    return builder.build();
                }
                return null;
            }
            return (Notification) invokeV.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, remoteViews, remoteViews2) == null) {
                hideNormalContent(remoteViews);
                remoteViews.removeAllViews(R.id.notification_main_column);
                remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
                remoteViews.setViewVisibility(R.id.notification_main_column, 0);
                if (Build.VERSION.SDK_INT >= 21) {
                    remoteViews.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? createColoredBitmap(i2, i3, 0) : (Bitmap) invokeII.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, notificationBuilderWithBuilderAccessor)) == null) {
                return null;
            }
            return (RemoteViews) invokeL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, notificationBuilderWithBuilderAccessor)) == null) {
                return null;
            }
            return (RemoteViews) invokeL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, notificationBuilderWithBuilderAccessor)) == null) {
                return null;
            }
            return (RemoteViews) invokeL.objValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            }
        }

        public void setBuilder(Builder builder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, builder) == null) || this.mBuilder == builder) {
                return;
            }
            this.mBuilder = builder;
            if (builder != null) {
                builder.setStyle(this);
            }
        }

        public Bitmap createColoredBitmap(IconCompat iconCompat, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, iconCompat, i2)) == null) ? createColoredBitmap(iconCompat, i2, 0) : (Bitmap) invokeLI.objValue;
        }

        private Bitmap createColoredBitmap(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIII = interceptable.invokeIII(65539, this, i2, i3, i4)) == null) ? createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, i2), i3, i4) : (Bitmap) invokeIII.objValue;
        }

        private Bitmap createColoredBitmap(IconCompat iconCompat, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, iconCompat, i2, i3)) == null) {
                Drawable loadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
                int intrinsicWidth = i3 == 0 ? loadDrawable.getIntrinsicWidth() : i3;
                if (i3 == 0) {
                    i3 = loadDrawable.getIntrinsicHeight();
                }
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
                loadDrawable.setBounds(0, 0, intrinsicWidth, i3);
                if (i2 != 0) {
                    loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
                }
                loadDrawable.draw(new Canvas(createBitmap));
                return createBitmap;
            }
            return (Bitmap) invokeLII.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class WearableExtender implements Extender {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        public static final int DEFAULT_FLAGS = 1;
        public static final int DEFAULT_GRAVITY = 80;
        public static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        public static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        public static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        public static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        public static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        public static final int FLAG_HINT_HIDE_ICON = 2;
        public static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        public static final int FLAG_START_SCROLL_BOTTOM = 8;
        public static final String KEY_ACTIONS = "actions";
        public static final String KEY_BACKGROUND = "background";
        public static final String KEY_BRIDGE_TAG = "bridgeTag";
        public static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        public static final String KEY_CONTENT_ICON = "contentIcon";
        public static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        public static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        public static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        public static final String KEY_DISMISSAL_ID = "dismissalId";
        public static final String KEY_DISPLAY_INTENT = "displayIntent";
        public static final String KEY_FLAGS = "flags";
        public static final String KEY_GRAVITY = "gravity";
        public static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        public static final String KEY_PAGES = "pages";
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<Action> mActions;
        public Bitmap mBackground;
        public String mBridgeTag;
        public int mContentActionIndex;
        public int mContentIcon;
        public int mContentIconGravity;
        public int mCustomContentHeight;
        public int mCustomSizePreset;
        public String mDismissalId;
        public PendingIntent mDisplayIntent;
        public int mFlags;
        public int mGravity;
        public int mHintScreenTimeout;
        public ArrayList<Notification> mPages;

        public WearableExtender() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        @RequiresApi(20)
        public static Notification.Action getActionFromActionCompat(Action action) {
            InterceptResult invokeL;
            Notification.Action.Builder builder;
            Bundle bundle;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, action)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    IconCompat iconCompat = action.getIconCompat();
                    builder = new Notification.Action.Builder(iconCompat == null ? null : iconCompat.toIcon(), action.getTitle(), action.getActionIntent());
                } else {
                    IconCompat iconCompat2 = action.getIconCompat();
                    builder = new Notification.Action.Builder((iconCompat2 == null || iconCompat2.getType() != 2) ? 0 : iconCompat2.getResId(), action.getTitle(), action.getActionIntent());
                }
                if (action.getExtras() != null) {
                    bundle = new Bundle(action.getExtras());
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
                if (Build.VERSION.SDK_INT >= 24) {
                    builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
                }
                builder.addExtras(bundle);
                RemoteInput[] remoteInputs = action.getRemoteInputs();
                if (remoteInputs != null) {
                    for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(remoteInputs)) {
                        builder.addRemoteInput(remoteInput);
                    }
                }
                return builder.build();
            }
            return (Notification.Action) invokeL.objValue;
        }

        private void setFlag(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.mFlags = i2 | this.mFlags;
                } else {
                    this.mFlags = (~i2) & this.mFlags;
                }
            }
        }

        public WearableExtender addAction(Action action) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, action)) == null) {
                this.mActions.add(action);
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        public WearableExtender addActions(List<Action> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                this.mActions.addAll(list);
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        @Deprecated
        public WearableExtender addPage(Notification notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, notification)) == null) {
                this.mPages.add(notification);
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        @Deprecated
        public WearableExtender addPages(List<Notification> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                this.mPages.addAll(list);
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        public WearableExtender clearActions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.mActions.clear();
                return this;
            }
            return (WearableExtender) invokeV.objValue;
        }

        @Deprecated
        public WearableExtender clearPages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                this.mPages.clear();
                return this;
            }
            return (WearableExtender) invokeV.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, builder)) == null) {
                Bundle bundle = new Bundle();
                if (!this.mActions.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.mActions.size());
                        Iterator<Action> it = this.mActions.iterator();
                        while (it.hasNext()) {
                            Action next = it.next();
                            int i2 = Build.VERSION.SDK_INT;
                            if (i2 >= 20) {
                                arrayList.add(getActionFromActionCompat(next));
                            } else if (i2 >= 16) {
                                arrayList.add(NotificationCompatJellybean.getBundleForAction(next));
                            }
                        }
                        bundle.putParcelableArrayList(KEY_ACTIONS, arrayList);
                    } else {
                        bundle.putParcelableArrayList(KEY_ACTIONS, null);
                    }
                }
                int i3 = this.mFlags;
                if (i3 != 1) {
                    bundle.putInt("flags", i3);
                }
                PendingIntent pendingIntent = this.mDisplayIntent;
                if (pendingIntent != null) {
                    bundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
                }
                if (!this.mPages.isEmpty()) {
                    ArrayList<Notification> arrayList2 = this.mPages;
                    bundle.putParcelableArray(KEY_PAGES, (Parcelable[]) arrayList2.toArray(new Notification[arrayList2.size()]));
                }
                Bitmap bitmap = this.mBackground;
                if (bitmap != null) {
                    bundle.putParcelable(KEY_BACKGROUND, bitmap);
                }
                int i4 = this.mContentIcon;
                if (i4 != 0) {
                    bundle.putInt(KEY_CONTENT_ICON, i4);
                }
                int i5 = this.mContentIconGravity;
                if (i5 != 8388613) {
                    bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i5);
                }
                int i6 = this.mContentActionIndex;
                if (i6 != -1) {
                    bundle.putInt(KEY_CONTENT_ACTION_INDEX, i6);
                }
                int i7 = this.mCustomSizePreset;
                if (i7 != 0) {
                    bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i7);
                }
                int i8 = this.mCustomContentHeight;
                if (i8 != 0) {
                    bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i8);
                }
                int i9 = this.mGravity;
                if (i9 != 80) {
                    bundle.putInt(KEY_GRAVITY, i9);
                }
                int i10 = this.mHintScreenTimeout;
                if (i10 != 0) {
                    bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i10);
                }
                String str = this.mDismissalId;
                if (str != null) {
                    bundle.putString(KEY_DISMISSAL_ID, str);
                }
                String str2 = this.mBridgeTag;
                if (str2 != null) {
                    bundle.putString(KEY_BRIDGE_TAG, str2);
                }
                builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
                return builder;
            }
            return (Builder) invokeL.objValue;
        }

        public List<Action> getActions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mActions : (List) invokeV.objValue;
        }

        @Deprecated
        public Bitmap getBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mBackground : (Bitmap) invokeV.objValue;
        }

        public String getBridgeTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mBridgeTag : (String) invokeV.objValue;
        }

        public int getContentAction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mContentActionIndex : invokeV.intValue;
        }

        @Deprecated
        public int getContentIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mContentIcon : invokeV.intValue;
        }

        @Deprecated
        public int getContentIconGravity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mContentIconGravity : invokeV.intValue;
        }

        public boolean getContentIntentAvailableOffline() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (this.mFlags & 1) != 0 : invokeV.booleanValue;
        }

        @Deprecated
        public int getCustomContentHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mCustomContentHeight : invokeV.intValue;
        }

        @Deprecated
        public int getCustomSizePreset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mCustomSizePreset : invokeV.intValue;
        }

        public String getDismissalId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mDismissalId : (String) invokeV.objValue;
        }

        @Deprecated
        public PendingIntent getDisplayIntent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mDisplayIntent : (PendingIntent) invokeV.objValue;
        }

        @Deprecated
        public int getGravity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mGravity : invokeV.intValue;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.mFlags & 32) != 0 : invokeV.booleanValue;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? (this.mFlags & 16) != 0 : invokeV.booleanValue;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.mFlags & 64) != 0 : invokeV.booleanValue;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (this.mFlags & 2) != 0 : invokeV.booleanValue;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mHintScreenTimeout : invokeV.intValue;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (this.mFlags & 4) != 0 : invokeV.booleanValue;
        }

        @Deprecated
        public List<Notification> getPages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mPages : (List) invokeV.objValue;
        }

        public boolean getStartScrollBottom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.mFlags & 8) != 0 : invokeV.booleanValue;
        }

        @Deprecated
        public WearableExtender setBackground(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bitmap)) == null) {
                this.mBackground = bitmap;
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        public WearableExtender setBridgeTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
                this.mBridgeTag = str;
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        public WearableExtender setContentAction(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
                this.mContentActionIndex = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        @Deprecated
        public WearableExtender setContentIcon(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
                this.mContentIcon = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        @Deprecated
        public WearableExtender setContentIconGravity(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
                this.mContentIconGravity = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                setFlag(1, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        @Deprecated
        public WearableExtender setCustomContentHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
                this.mCustomContentHeight = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        @Deprecated
        public WearableExtender setCustomSizePreset(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
                this.mCustomSizePreset = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        public WearableExtender setDismissalId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                this.mDismissalId = str;
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        @Deprecated
        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, pendingIntent)) == null) {
                this.mDisplayIntent = pendingIntent;
                return this;
            }
            return (WearableExtender) invokeL.objValue;
        }

        @Deprecated
        public WearableExtender setGravity(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
                this.mGravity = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
                setFlag(32, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
                setFlag(16, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
                setFlag(64, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        @Deprecated
        public WearableExtender setHintHideIcon(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
                setFlag(2, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        @Deprecated
        public WearableExtender setHintScreenTimeout(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
                this.mHintScreenTimeout = i2;
                return this;
            }
            return (WearableExtender) invokeI.objValue;
        }

        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
                setFlag(4, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
                setFlag(8, z);
                return this;
            }
            return (WearableExtender) invokeZ.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public WearableExtender m4clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mActions = new ArrayList<>(this.mActions);
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mDisplayIntent = this.mDisplayIntent;
                wearableExtender.mPages = new ArrayList<>(this.mPages);
                wearableExtender.mBackground = this.mBackground;
                wearableExtender.mContentIcon = this.mContentIcon;
                wearableExtender.mContentIconGravity = this.mContentIconGravity;
                wearableExtender.mContentActionIndex = this.mContentActionIndex;
                wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
                wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
                wearableExtender.mGravity = this.mGravity;
                wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
                wearableExtender.mDismissalId = this.mDismissalId;
                wearableExtender.mBridgeTag = this.mBridgeTag;
                return wearableExtender;
            }
            return (WearableExtender) invokeV.objValue;
        }

        public WearableExtender(Notification notification) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notification};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mActions = new ArrayList<>();
            this.mFlags = 1;
            this.mPages = new ArrayList<>();
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_ACTIONS);
                if (Build.VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 20) {
                            actionArr[i4] = NotificationCompat.getActionCompatFromAction((Notification.Action) parcelableArrayList.get(i4));
                        } else if (i5 >= 16) {
                            actionArr[i4] = NotificationCompatJellybean.getActionFromBundle((Bundle) parcelableArrayList.get(i4));
                        }
                    }
                    Collections.addAll(this.mActions, actionArr);
                }
                this.mFlags = bundle.getInt("flags", 1);
                this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
            }
        }
    }

    @Deprecated
    public NotificationCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Action getAction(Notification notification, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, notification, i2)) == null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 20) {
                return getActionCompatFromAction(notification.actions[i2]);
            }
            if (i3 >= 19) {
                Notification.Action action = notification.actions[i2];
                SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
                return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, sparseParcelableArray != null ? (Bundle) sparseParcelableArray.get(i2) : null);
            } else if (i3 >= 16) {
                return NotificationCompatJellybean.getAction(notification, i2);
            } else {
                return null;
            }
        }
        return (Action) invokeLI.objValue;
    }

    @RequiresApi(20)
    public static Action getActionCompatFromAction(Notification.Action action) {
        InterceptResult invokeL;
        RemoteInput[] remoteInputArr;
        boolean z;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, action)) == null) {
            android.app.RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs == null) {
                remoteInputArr = null;
            } else {
                RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
                for (int i4 = 0; i4 < remoteInputs.length; i4++) {
                    android.app.RemoteInput remoteInput = remoteInputs[i4];
                    remoteInputArr2[i4] = new RemoteInput(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
                }
                remoteInputArr = remoteInputArr2;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                z = action.getExtras().getBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES) || action.getAllowGeneratedReplies();
            } else {
                z = action.getExtras().getBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES);
            }
            boolean z2 = z;
            boolean z3 = action.getExtras().getBoolean(Action.EXTRA_SHOWS_USER_INTERFACE, true);
            if (Build.VERSION.SDK_INT >= 28) {
                i2 = action.getSemanticAction();
            } else {
                i2 = action.getExtras().getInt(Action.EXTRA_SEMANTIC_ACTION, 0);
            }
            int i5 = i2;
            boolean isContextual = Build.VERSION.SDK_INT >= 29 ? action.isContextual() : false;
            if (Build.VERSION.SDK_INT >= 23) {
                if (action.getIcon() == null && (i3 = action.icon) != 0) {
                    return new Action(i3, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z2, i5, z3, isContextual);
                }
                return new Action(action.getIcon() != null ? IconCompat.createFromIconOrNullIfZeroResId(action.getIcon()) : null, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z2, i5, z3, isContextual);
            }
            return new Action(action.icon, action.title, action.actionIntent, action.getExtras(), remoteInputArr, (RemoteInput[]) null, z2, i5, z3, isContextual);
        }
        return (Action) invokeL.objValue;
    }

    public static int getActionCount(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, notification)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 19) {
                if (i2 >= 16) {
                    return NotificationCompatJellybean.getActionCount(notification);
                }
                return 0;
            }
            Notification.Action[] actionArr = notification.actions;
            if (actionArr != null) {
                return actionArr.length;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return notification.getAllowSystemGeneratedContextualActions();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int getBadgeIconType(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return notification.getBadgeIconType();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return BubbleMetadata.fromPlatform(notification.getBubbleMetadata());
            }
            return null;
        }
        return (BubbleMetadata) invokeL.objValue;
    }

    public static String getCategory(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return notification.category;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getChannelId(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return notification.getChannelId();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @RequiresApi(19)
    public static CharSequence getContentTitle(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, notification)) == null) ? notification.extras.getCharSequence(EXTRA_TITLE) : (CharSequence) invokeL.objValue;
    }

    @Nullable
    public static Bundle getExtras(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, notification)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 19) {
                return notification.extras;
            }
            if (i2 >= 16) {
                return NotificationCompatJellybean.getExtras(notification);
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static String getGroup(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, notification)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 20) {
                return notification.getGroup();
            }
            if (i2 >= 19) {
                return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
            }
            if (i2 >= 16) {
                return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int getGroupAlertBehavior(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return notification.getGroupAlertBehavior();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @RequiresApi(21)
    public static List<Action> getInvisibleActions(Notification notification) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, notification)) == null) {
            ArrayList arrayList = new ArrayList();
            Bundle bundle2 = notification.extras.getBundle(CarExtender.EXTRA_CAR_EXTENDER);
            if (bundle2 != null && (bundle = bundle2.getBundle(CarExtender.EXTRA_INVISIBLE_ACTIONS)) != null) {
                for (int i2 = 0; i2 < bundle.size(); i2++) {
                    arrayList.add(NotificationCompatJellybean.getActionFromBundle(bundle.getBundle(Integer.toString(i2))));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean getLocalOnly(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, notification)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 20) {
                return (notification.flags & 256) != 0;
            } else if (i2 >= 19) {
                return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            } else {
                if (i2 >= 16) {
                    return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bundle, str)) == null) {
            Parcelable[] parcelableArray = bundle.getParcelableArray(str);
            if (!(parcelableArray instanceof Notification[]) && parcelableArray != null) {
                Notification[] notificationArr = new Notification[parcelableArray.length];
                for (int i2 = 0; i2 < parcelableArray.length; i2++) {
                    notificationArr[i2] = (Notification) parcelableArray[i2];
                }
                bundle.putParcelableArray(str, notificationArr);
                return notificationArr;
            }
            return (Notification[]) parcelableArray;
        }
        return (Notification[]) invokeLL.objValue;
    }

    public static String getShortcutId(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return notification.getShortcutId();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getSortKey(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, notification)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 20) {
                return notification.getSortKey();
            }
            if (i2 >= 19) {
                return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
            }
            if (i2 >= 16) {
                return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long getTimeoutAfter(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, notification)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return notification.getTimeoutAfter();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static boolean isGroupSummary(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, notification)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 20) {
                return (notification.flags & 512) != 0;
            } else if (i2 >= 19) {
                return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            } else {
                if (i2 >= 16) {
                    return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes.dex */
    public static final class CarExtender implements Extender {
        public static /* synthetic */ Interceptable $ic = null;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        public static final String EXTRA_COLOR = "app_color";
        public static final String EXTRA_CONVERSATION = "car_conversation";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        public static final String EXTRA_LARGE_ICON = "large_icon";
        public static final String KEY_AUTHOR = "author";
        public static final String KEY_MESSAGES = "messages";
        public static final String KEY_ON_READ = "on_read";
        public static final String KEY_ON_REPLY = "on_reply";
        public static final String KEY_PARTICIPANTS = "participants";
        public static final String KEY_REMOTE_INPUT = "remote_input";
        public static final String KEY_TEXT = "text";
        public static final String KEY_TIMESTAMP = "timestamp";
        public transient /* synthetic */ FieldHolder $fh;
        public int mColor;
        public Bitmap mLargeIcon;
        public UnreadConversation mUnreadConversation;

        @Deprecated
        /* loaded from: classes.dex */
        public static class UnreadConversation {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final long mLatestTimestamp;
            public final String[] mMessages;
            public final String[] mParticipants;
            public final PendingIntent mReadPendingIntent;
            public final RemoteInput mRemoteInput;
            public final PendingIntent mReplyPendingIntent;

            /* loaded from: classes.dex */
            public static class Builder {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public long mLatestTimestamp;
                public final List<String> mMessages;
                public final String mParticipant;
                public PendingIntent mReadPendingIntent;
                public RemoteInput mRemoteInput;
                public PendingIntent mReplyPendingIntent;

                public Builder(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mMessages = new ArrayList();
                    this.mParticipant = str;
                }

                public Builder addMessage(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                        this.mMessages.add(str);
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public UnreadConversation build() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        List<String> list = this.mMessages;
                        return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                    }
                    return (UnreadConversation) invokeV.objValue;
                }

                public Builder setLatestTimestamp(long j2) {
                    InterceptResult invokeJ;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                        this.mLatestTimestamp = j2;
                        return this;
                    }
                    return (Builder) invokeJ.objValue;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pendingIntent)) == null) {
                        this.mReadPendingIntent = pendingIntent;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    InterceptResult invokeLL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, pendingIntent, remoteInput)) == null) {
                        this.mRemoteInput = remoteInput;
                        this.mReplyPendingIntent = pendingIntent;
                        return this;
                    }
                    return (Builder) invokeLL.objValue;
                }
            }

            public UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {strArr, remoteInput, pendingIntent, pendingIntent2, strArr2, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j2;
            }

            public long getLatestTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLatestTimestamp : invokeV.longValue;
            }

            public String[] getMessages() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMessages : (String[]) invokeV.objValue;
            }

            public String getParticipant() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    String[] strArr = this.mParticipants;
                    if (strArr.length > 0) {
                        return strArr[0];
                    }
                    return null;
                }
                return (String) invokeV.objValue;
            }

            public String[] getParticipants() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mParticipants : (String[]) invokeV.objValue;
            }

            public PendingIntent getReadPendingIntent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mReadPendingIntent : (PendingIntent) invokeV.objValue;
            }

            public RemoteInput getRemoteInput() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRemoteInput : (RemoteInput) invokeV.objValue;
            }

            public PendingIntent getReplyPendingIntent() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mReplyPendingIntent : (PendingIntent) invokeV.objValue;
            }
        }

        public CarExtender() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mColor = 0;
        }

        @RequiresApi(21)
        public static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation unreadConversation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, unreadConversation)) == null) {
                Bundle bundle = new Bundle();
                String str = (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) ? null : unreadConversation.getParticipants()[0];
                int length = unreadConversation.getMessages().length;
                Parcelable[] parcelableArr = new Parcelable[length];
                for (int i2 = 0; i2 < length; i2++) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("text", unreadConversation.getMessages()[i2]);
                    bundle2.putString(KEY_AUTHOR, str);
                    parcelableArr[i2] = bundle2;
                }
                bundle.putParcelableArray(KEY_MESSAGES, parcelableArr);
                RemoteInput remoteInput = unreadConversation.getRemoteInput();
                if (remoteInput != null) {
                    bundle.putParcelable(KEY_REMOTE_INPUT, new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build());
                }
                bundle.putParcelable(KEY_ON_REPLY, unreadConversation.getReplyPendingIntent());
                bundle.putParcelable(KEY_ON_READ, unreadConversation.getReadPendingIntent());
                bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
                bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
                return bundle;
            }
            return (Bundle) invokeL.objValue;
        }

        @RequiresApi(21)
        public static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle bundle) {
            InterceptResult invokeL;
            String[] strArr;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
                RemoteInput remoteInput = null;
                if (bundle == null) {
                    return null;
                }
                Parcelable[] parcelableArray = bundle.getParcelableArray(KEY_MESSAGES);
                if (parcelableArray != null) {
                    int length = parcelableArray.length;
                    String[] strArr2 = new String[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        if (parcelableArray[i2] instanceof Bundle) {
                            strArr2[i2] = ((Bundle) parcelableArray[i2]).getString("text");
                            if (strArr2[i2] != null) {
                            }
                        }
                        z = false;
                        break;
                    }
                    z = true;
                    if (!z) {
                        return null;
                    }
                    strArr = strArr2;
                } else {
                    strArr = null;
                }
                PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(KEY_ON_READ);
                PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable(KEY_ON_REPLY);
                android.app.RemoteInput remoteInput2 = (android.app.RemoteInput) bundle.getParcelable(KEY_REMOTE_INPUT);
                String[] stringArray = bundle.getStringArray(KEY_PARTICIPANTS);
                if (stringArray == null || stringArray.length != 1) {
                    return null;
                }
                if (remoteInput2 != null) {
                    remoteInput = new RemoteInput(remoteInput2.getResultKey(), remoteInput2.getLabel(), remoteInput2.getChoices(), remoteInput2.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput2.getEditChoicesBeforeSending() : 0, remoteInput2.getExtras(), null);
                }
                return new UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle.getLong("timestamp"));
            }
            return (UnreadConversation) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Extender
        public Builder extend(Builder builder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, builder)) == null) {
                if (Build.VERSION.SDK_INT < 21) {
                    return builder;
                }
                Bundle bundle = new Bundle();
                Bitmap bitmap = this.mLargeIcon;
                if (bitmap != null) {
                    bundle.putParcelable(EXTRA_LARGE_ICON, bitmap);
                }
                int i2 = this.mColor;
                if (i2 != 0) {
                    bundle.putInt(EXTRA_COLOR, i2);
                }
                UnreadConversation unreadConversation = this.mUnreadConversation;
                if (unreadConversation != null) {
                    bundle.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(unreadConversation));
                }
                builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
                return builder;
            }
            return (Builder) invokeL.objValue;
        }

        @ColorInt
        public int getColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mColor : invokeV.intValue;
        }

        public Bitmap getLargeIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLargeIcon : (Bitmap) invokeV.objValue;
        }

        @Deprecated
        public UnreadConversation getUnreadConversation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUnreadConversation : (UnreadConversation) invokeV.objValue;
        }

        public CarExtender setColor(@ColorInt int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.mColor = i2;
                return this;
            }
            return (CarExtender) invokeI.objValue;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bitmap)) == null) {
                this.mLargeIcon = bitmap;
                return this;
            }
            return (CarExtender) invokeL.objValue;
        }

        @Deprecated
        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, unreadConversation)) == null) {
                this.mUnreadConversation = unreadConversation;
                return this;
            }
            return (CarExtender) invokeL.objValue;
        }

        public CarExtender(Notification notification) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notification};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mColor = 0;
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            Bundle bundle = NotificationCompat.getExtras(notification) == null ? null : NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
            if (bundle != null) {
                this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class InboxStyle extends Style {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<CharSequence> mTexts;

        public InboxStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTexts = new ArrayList<>();
        }

        public InboxStyle addLine(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
                this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
                return this;
            }
            return (InboxStyle) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notificationBuilderWithBuilderAccessor) == null) || Build.VERSION.SDK_INT < 16) {
                return;
            }
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet) {
                bigContentTitle.setSummaryText(this.mSummaryText);
            }
            Iterator<CharSequence> it = this.mTexts.iterator();
            while (it.hasNext()) {
                bigContentTitle.addLine(it.next());
            }
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence)) == null) {
                this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
                return this;
            }
            return (InboxStyle) invokeL.objValue;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
                this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
                this.mSummaryTextSet = true;
                return this;
            }
            return (InboxStyle) invokeL.objValue;
        }

        public InboxStyle(Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTexts = new ArrayList<>();
            setBuilder(builder);
        }
    }

    /* loaded from: classes.dex */
    public static class MessagingStyle extends Style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public CharSequence mConversationTitle;
        @Nullable
        public Boolean mIsGroupConversation;
        public final List<Message> mMessages;
        public Person mUser;

        public MessagingStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMessages = new ArrayList();
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, notification)) == null) {
                Bundle extras = NotificationCompat.getExtras(notification);
                if (extras == null || extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || extras.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                    try {
                        MessagingStyle messagingStyle = new MessagingStyle();
                        messagingStyle.restoreFromCompatExtras(extras);
                        return messagingStyle;
                    } catch (ClassCastException unused) {
                        return null;
                    }
                }
                return null;
            }
            return (MessagingStyle) invokeL.objValue;
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            InterceptResult invokeV;
            List<Message> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                    Message message = this.mMessages.get(size);
                    if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                        return message;
                    }
                }
                if (this.mMessages.isEmpty()) {
                    return null;
                }
                return this.mMessages.get(list.size() - 1);
            }
            return (Message) invokeV.objValue;
        }

        private boolean hasMessagesWithoutSender() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
                for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                    Message message = this.mMessages.get(size);
                    if (message.getPerson() != null && message.getPerson().getName() == null) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) ? new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i2), null) : (TextAppearanceSpan) invokeI.objValue;
        }

        private CharSequence makeMessageLine(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, message)) == null) {
                BidiFormatter bidiFormatter = BidiFormatter.getInstance();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                boolean z = Build.VERSION.SDK_INT >= 21;
                int i2 = z ? -16777216 : -1;
                String name = message.getPerson() == null ? "" : message.getPerson().getName();
                if (TextUtils.isEmpty(name)) {
                    name = this.mUser.getName();
                    if (z && this.mBuilder.getColor() != 0) {
                        i2 = this.mBuilder.getColor();
                    }
                }
                CharSequence unicodeWrap = bidiFormatter.unicodeWrap(name);
                spannableStringBuilder.append(unicodeWrap);
                spannableStringBuilder.setSpan(makeFontColorSpan(i2), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) GlideException.IndentedAppendable.INDENT).append(bidiFormatter.unicodeWrap(message.getText() != null ? message.getText() : ""));
                return spannableStringBuilder;
            }
            return (CharSequence) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void addCompatExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                super.addCompatExtras(bundle);
                bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
                bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
                bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
                if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                    bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
                }
                if (!this.mMessages.isEmpty()) {
                    bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
                }
                Boolean bool = this.mIsGroupConversation;
                if (bool != null) {
                    bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
                }
            }
        }

        @Deprecated
        public MessagingStyle addMessage(CharSequence charSequence, long j2, CharSequence charSequence2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{charSequence, Long.valueOf(j2), charSequence2})) == null) {
                this.mMessages.add(new Message(charSequence, j2, new Person.Builder().setName(charSequence2).build()));
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
                return this;
            }
            return (MessagingStyle) invokeCommon.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence text;
            Notification.MessagingStyle messagingStyle;
            Notification.MessagingStyle.Message message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, notificationBuilderWithBuilderAccessor) == null) {
                setGroupConversation(isGroupConversation());
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 24) {
                    if (i2 >= 28) {
                        messagingStyle = new Notification.MessagingStyle(this.mUser.toAndroidPerson());
                    } else {
                        messagingStyle = new Notification.MessagingStyle(this.mUser.getName());
                    }
                    if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                        messagingStyle.setConversationTitle(this.mConversationTitle);
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        messagingStyle.setGroupConversation(this.mIsGroupConversation.booleanValue());
                    }
                    for (Message message2 : this.mMessages) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            Person person = message2.getPerson();
                            message = new Notification.MessagingStyle.Message(message2.getText(), message2.getTimestamp(), person == null ? null : person.toAndroidPerson());
                        } else {
                            message = new Notification.MessagingStyle.Message(message2.getText(), message2.getTimestamp(), message2.getPerson() != null ? message2.getPerson().getName() : null);
                        }
                        if (message2.getDataMimeType() != null) {
                            message.setData(message2.getDataMimeType(), message2.getDataUri());
                        }
                        messagingStyle.addMessage(message);
                    }
                    messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                    return;
                }
                Message findLatestIncomingMessage = findLatestIncomingMessage();
                if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
                } else if (findLatestIncomingMessage != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                    if (findLatestIncomingMessage.getPerson() != null) {
                        notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(findLatestIncomingMessage.getPerson().getName());
                    }
                }
                if (findLatestIncomingMessage != null) {
                    Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                    if (this.mConversationTitle != null) {
                        text = makeMessageLine(findLatestIncomingMessage);
                    } else {
                        text = findLatestIncomingMessage.getText();
                    }
                    builder.setContentText(text);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    boolean z = this.mConversationTitle != null || hasMessagesWithoutSender();
                    for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                        Message message3 = this.mMessages.get(size);
                        CharSequence makeMessageLine = z ? makeMessageLine(message3) : message3.getText();
                        if (size != this.mMessages.size() - 1) {
                            spannableStringBuilder.insert(0, (CharSequence) StringUtils.LF);
                        }
                        spannableStringBuilder.insert(0, makeMessageLine);
                    }
                    new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText(spannableStringBuilder);
                }
            }
        }

        @Nullable
        public CharSequence getConversationTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mConversationTitle : (CharSequence) invokeV.objValue;
        }

        public List<Message> getMessages() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMessages : (List) invokeV.objValue;
        }

        public Person getUser() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mUser : (Person) invokeV.objValue;
        }

        @Deprecated
        public CharSequence getUserDisplayName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mUser.getName() : (CharSequence) invokeV.objValue;
        }

        public boolean isGroupConversation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Builder builder = this.mBuilder;
                if (builder != null && builder.mContext.getApplicationInfo().targetSdkVersion < 28 && this.mIsGroupConversation == null) {
                    return this.mConversationTitle != null;
                }
                Boolean bool = this.mIsGroupConversation;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
                this.mMessages.clear();
                if (bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                    this.mUser = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
                } else {
                    this.mUser = new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
                }
                CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
                this.mConversationTitle = charSequence;
                if (charSequence == null) {
                    this.mConversationTitle = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
                }
                Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
                if (parcelableArray != null) {
                    this.mMessages.addAll(Message.getMessagesFromBundleArray(parcelableArray));
                }
                if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                    this.mIsGroupConversation = Boolean.valueOf(bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
                }
            }
        }

        public MessagingStyle setConversationTitle(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
                this.mConversationTitle = charSequence;
                return this;
            }
            return (MessagingStyle) invokeL.objValue;
        }

        public MessagingStyle setGroupConversation(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.mIsGroupConversation = Boolean.valueOf(z);
                return this;
            }
            return (MessagingStyle) invokeZ.objValue;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mMessages = new ArrayList();
            this.mUser = new Person.Builder().setName(charSequence).build();
        }

        /* loaded from: classes.dex */
        public static final class Message {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String KEY_DATA_MIME_TYPE = "type";
            public static final String KEY_DATA_URI = "uri";
            public static final String KEY_EXTRAS_BUNDLE = "extras";
            public static final String KEY_NOTIFICATION_PERSON = "sender_person";
            public static final String KEY_PERSON = "person";
            public static final String KEY_SENDER = "sender";
            public static final String KEY_TEXT = "text";
            public static final String KEY_TIMESTAMP = "time";
            public transient /* synthetic */ FieldHolder $fh;
            @Nullable
            public String mDataMimeType;
            @Nullable
            public Uri mDataUri;
            public Bundle mExtras;
            @Nullable
            public final Person mPerson;
            public final CharSequence mText;
            public final long mTimestamp;

            public Message(CharSequence charSequence, long j2, @Nullable Person person) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {charSequence, Long.valueOf(j2), person};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mExtras = new Bundle();
                this.mText = charSequence;
                this.mTimestamp = j2;
                this.mPerson = person;
            }

            @NonNull
            public static Bundle[] getBundleArrayForMessages(List<Message> list) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
                    Bundle[] bundleArr = new Bundle[list.size()];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        bundleArr[i2] = list.get(i2).toBundle();
                    }
                    return bundleArr;
                }
                return (Bundle[]) invokeL.objValue;
            }

            @Nullable
            public static Message getMessageFromBundle(Bundle bundle) {
                InterceptResult invokeL;
                Person build;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bundle)) == null) {
                    try {
                        if (bundle.containsKey("text") && bundle.containsKey("time")) {
                            if (bundle.containsKey("person")) {
                                build = Person.fromBundle(bundle.getBundle("person"));
                            } else if (bundle.containsKey(KEY_NOTIFICATION_PERSON) && Build.VERSION.SDK_INT >= 28) {
                                build = Person.fromAndroidPerson((android.app.Person) bundle.getParcelable(KEY_NOTIFICATION_PERSON));
                            } else {
                                build = bundle.containsKey("sender") ? new Person.Builder().setName(bundle.getCharSequence("sender")).build() : null;
                            }
                            Message message = new Message(bundle.getCharSequence("text"), bundle.getLong("time"), build);
                            if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                                message.setData(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                            }
                            if (bundle.containsKey("extras")) {
                                message.getExtras().putAll(bundle.getBundle("extras"));
                            }
                            return message;
                        }
                    } catch (ClassCastException unused) {
                    }
                    return null;
                }
                return (Message) invokeL.objValue;
            }

            @NonNull
            public static List<Message> getMessagesFromBundleArray(Parcelable[] parcelableArr) {
                InterceptResult invokeL;
                Message messageFromBundle;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parcelableArr)) == null) {
                    ArrayList arrayList = new ArrayList(parcelableArr.length);
                    for (int i2 = 0; i2 < parcelableArr.length; i2++) {
                        if ((parcelableArr[i2] instanceof Bundle) && (messageFromBundle = getMessageFromBundle((Bundle) parcelableArr[i2])) != null) {
                            arrayList.add(messageFromBundle);
                        }
                    }
                    return arrayList;
                }
                return (List) invokeL.objValue;
            }

            private Bundle toBundle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
                    Bundle bundle = new Bundle();
                    CharSequence charSequence = this.mText;
                    if (charSequence != null) {
                        bundle.putCharSequence("text", charSequence);
                    }
                    bundle.putLong("time", this.mTimestamp);
                    Person person = this.mPerson;
                    if (person != null) {
                        bundle.putCharSequence("sender", person.getName());
                        if (Build.VERSION.SDK_INT >= 28) {
                            bundle.putParcelable(KEY_NOTIFICATION_PERSON, this.mPerson.toAndroidPerson());
                        } else {
                            bundle.putBundle("person", this.mPerson.toBundle());
                        }
                    }
                    String str = this.mDataMimeType;
                    if (str != null) {
                        bundle.putString("type", str);
                    }
                    Uri uri = this.mDataUri;
                    if (uri != null) {
                        bundle.putParcelable("uri", uri);
                    }
                    Bundle bundle2 = this.mExtras;
                    if (bundle2 != null) {
                        bundle.putBundle("extras", bundle2);
                    }
                    return bundle;
                }
                return (Bundle) invokeV.objValue;
            }

            @Nullable
            public String getDataMimeType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDataMimeType : (String) invokeV.objValue;
            }

            @Nullable
            public Uri getDataUri() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDataUri : (Uri) invokeV.objValue;
            }

            @NonNull
            public Bundle getExtras() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtras : (Bundle) invokeV.objValue;
            }

            @Nullable
            public Person getPerson() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPerson : (Person) invokeV.objValue;
            }

            @Nullable
            @Deprecated
            public CharSequence getSender() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Person person = this.mPerson;
                    if (person == null) {
                        return null;
                    }
                    return person.getName();
                }
                return (CharSequence) invokeV.objValue;
            }

            @NonNull
            public CharSequence getText() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mText : (CharSequence) invokeV.objValue;
            }

            public long getTimestamp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTimestamp : invokeV.longValue;
            }

            public Message setData(String str, Uri uri) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, uri)) == null) {
                    this.mDataMimeType = str;
                    this.mDataUri = uri;
                    return this;
                }
                return (Message) invokeLL.objValue;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            @Deprecated
            public Message(CharSequence charSequence, long j2, CharSequence charSequence2) {
                this(charSequence, j2, new Person.Builder().setName(charSequence2).build());
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {charSequence, Long.valueOf(j2), charSequence2};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this((CharSequence) objArr2[0], ((Long) objArr2[1]).longValue(), (Person) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
            }
        }

        public MessagingStyle(@NonNull Person person) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {person};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mMessages = new ArrayList();
            if (!TextUtils.isEmpty(person.getName())) {
                this.mUser = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }

        public MessagingStyle addMessage(CharSequence charSequence, long j2, Person person) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{charSequence, Long.valueOf(j2), person})) == null) {
                addMessage(new Message(charSequence, j2, person));
                return this;
            }
            return (MessagingStyle) invokeCommon.objValue;
        }

        public MessagingStyle addMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message)) == null) {
                this.mMessages.add(message);
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
                return this;
            }
            return (MessagingStyle) invokeL.objValue;
        }
    }
}
