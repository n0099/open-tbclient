package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class UgcVoteInfo implements NoProGuard, Serializable {
    @c("ext")
    public ExtInfo extInfo;
    @c("options")
    public List<VoteOption> voteOptions = new ArrayList();
    @c("title")
    public String voteTitle;

    /* loaded from: classes13.dex */
    public class VoteOption {
        @c("tag_name")
        public String voteTagName;
        @c("checked")
        public String voteTagState;
        @c("value")
        public String voteValue;

        public VoteOption() {
        }
    }

    /* loaded from: classes13.dex */
    public class ExtInfo {
        @c("vote_id")
        public String voteId;
        @c("type")
        public String voteType;
        @c("type_id")
        public String voteTypeId;

        public ExtInfo() {
        }
    }
}
