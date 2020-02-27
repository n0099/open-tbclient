package com.baidu.live.tbadk.share.single;

import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
/* loaded from: classes3.dex */
public class ShareSingleManager {
    private IShareChannel mShareChannel;
    private IShareChannelBuild mShareChannelBuilder;

    public static ShareSingleManager getInstance() {
        return InstanceHolder.sInst;
    }

    private ShareSingleManager() {
    }

    public void init(IShareChannelBuild iShareChannelBuild) {
        this.mShareChannelBuilder = iShareChannelBuild;
        build();
    }

    public IShareChannel buildShareChannel() {
        if (this.mShareChannel != null) {
            return this.mShareChannel;
        }
        build();
        return this.mShareChannel;
    }

    private void build() {
        if (this.mShareChannelBuilder == null) {
            throw new RuntimeException("ShareChannelBuilder must not be null! should invoke ShareSingleManager.init() first~");
        }
        this.mShareChannel = this.mShareChannelBuilder.build();
    }

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final ShareSingleManager sInst = new ShareSingleManager();
    }
}
