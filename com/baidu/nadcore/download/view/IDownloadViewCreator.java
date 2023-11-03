package com.baidu.nadcore.download.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tieba.oh0;
/* loaded from: classes3.dex */
public interface IDownloadViewCreator {
    public static final ServiceReference a = new ServiceReference("nad.core", "downloadview");
    public static final IDownloadViewCreator b = new a();

    /* loaded from: classes3.dex */
    public enum ViewType {
        LP_DOWNLOAD_VIEW,
        FEED_DOWNLOAD_VIEW,
        REWARD_DOWNLOAD_VIEW,
        DEFAULT
    }

    oh0<?> a(@NonNull ViewGroup viewGroup, ViewType viewType);

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ViewType.values().length];
            a = iArr;
            try {
                iArr[ViewType.LP_DOWNLOAD_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ViewType.FEED_DOWNLOAD_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ViewType.REWARD_DOWNLOAD_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ViewType.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements IDownloadViewCreator {
        @Override // com.baidu.nadcore.download.view.IDownloadViewCreator
        public oh0<?> a(@NonNull ViewGroup viewGroup, ViewType viewType) {
            int i = b.a[viewType.ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    return null;
                }
                AdProgressButton adProgressButton = new AdProgressButton(viewGroup.getContext());
                adProgressButton.c(viewGroup);
                return adProgressButton;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = new DefaultDownloadViewLP(viewGroup.getContext());
            defaultDownloadViewLP.c(viewGroup);
            return defaultDownloadViewLP;
        }
    }
}
